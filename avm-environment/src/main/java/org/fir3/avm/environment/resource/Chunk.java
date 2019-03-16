package org.fir3.avm.environment.resource;

import lombok.Data;
import lombok.extern.java.Log;
import org.fir3.avm.environment.resource.io.LEInputStream;
import org.fir3.avm.environment.resource.io.ResourceInputStream;
import org.fir3.avm.environment.resource.io.XmlInputStream;
import org.fir3.avm.environment.util.CollectionUtil;
import org.fir3.avm.environment.util.StreamUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Set;

@Data
@Log
public class Chunk {
    private static class Util {
        private static DocumentBuilder documentBuilder;

        static DocumentBuilder getDocumentBuilder() {
            if (Util.documentBuilder == null) {
                try {
                    Util.documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                } catch (ParserConfigurationException e) {
                    throw new IllegalStateException(e);
                }
            }

            return Util.documentBuilder;
        }
    }

    private static final ResourceType[] NODE_TYPES = new ResourceType[] {
            ResourceType.XmlFirstChunk, ResourceType.XmlStartNamespace, ResourceType.XmlEndNamespace,
            ResourceType.XmlStartElement, ResourceType.XmlEndElement, ResourceType.XmlCdata
    };

    private final ChunkHeader header;
    private final byte[] data;

    public Document getDocument() throws IOException {
        this.expectType(ResourceType.Xml);

        // Create the instance of the resulting object

        Document result = Util.getDocumentBuilder().newDocument();
        Node currentNode = result;

        // Deserialize the document

        try (ResourceInputStream in = new ResourceInputStream(new ByteArrayInputStream(this.data))) {
            // Variables for the reading process

            boolean expectContinuation = true;
            int depth = 0;

            // Variables for the proceeding process

            StringPool strings = null;

            while (expectContinuation) {
                Chunk chunk = in.readChunk();

                // Increase/decrease the depth depending on whether an element/namespace is starting/ending

                Set<ResourceType> types = chunk.getHeader().getType();

                if (types.contains(ResourceType.XmlStartNamespace) || types.contains(ResourceType.XmlStartElement)) {
                    depth++;
                }

                if (types.contains(ResourceType.XmlEndNamespace) || types.contains(ResourceType.XmlEndElement)) {
                    depth--;
                    expectContinuation = depth > 0;
                }

                // Proceed the chunk

                ResourceType type = CollectionUtil.getFirst(types);

                if (type == ResourceType.StringPool) {
                    if (strings != null) {
                        throw new UnsupportedOperationException("No more than one StringPool is supported!");
                    }

                    strings = chunk.getStringPool();
                    continue;
                }

                if (type == ResourceType.XmlResourceMap) {
                    log.info("Ignoring XmlResourceMap chunk (not implemented)");
                    continue;
                }

                if (Arrays.binarySearch(Chunk.NODE_TYPES, type) >= 0) {
                    XmlTreeNode node = chunk.getXmlTreeNode(strings);

                    System.out.println(node);
                    continue;
                }

                throw new IOException("Unexpected resource type: " + type);
            }
        }

        return result;
    }

    public StringPool getStringPool() throws IOException {
        this.expectType(ResourceType.StringPool);

        // NOTE: At the moment this implementation ignores everything besides a string index and the string itself,
        //       maybe we should implement the rest in the future (if required).

        ChunkHeader.StringPoolHeader header = (ChunkHeader.StringPoolHeader) this.header;

        // Create the array that will contain the decoded strings

        long stringCount = header.getStringCount();

        if (stringCount > Integer.MAX_VALUE) {
            throw new UnsupportedOperationException("Cannot have more strings in a string pool than a signed integer " +
                    "is large!");
        }

        String[] strings = new String[(int) stringCount];

        // Decode the strings

        try (LEInputStream indexStream = new LEInputStream(new ByteArrayInputStream(this.data))) {
            for (int i = 0; i < strings.length; i++) {
                long index = indexStream.readUint32();

                if (index > Integer.MAX_VALUE) {
                    throw new UnsupportedOperationException("Indices greater than singed integer are not supported!");
                }

                // Calculate the string's offset and the remaining bytes in the data array

                int offset = (int) (header.getStringsStart() - header.getHeaderSize() + index);
                int remaining = this.data.length - offset;

                // Read and decode the string data

                try (LEInputStream stringStream = new LEInputStream(new ByteArrayInputStream(this.data, offset,
                        remaining))) {
                    // Determine the length of the final string

                    int length = stringStream.readUint16();

                    if ((length & 0x8000) == 0x8000) {
                        length &= 0x7FFF;
                        length <<= 16;
                        length |= stringStream.readUint16();
                    }

                    // Read the string's bytes from the stream (UTF-16 encoded)

                    byte[] data = new byte[length * 2];
                    StreamUtil.readFully(stringStream, data);

                    // Expecting two zero bytes

                    if (stringStream.readUint16() != 0x0000) {
                        throw new IOException("Expected string terminator!");
                    }

                    // Decode the string data

                    strings[i] = new String(data, StandardCharsets.UTF_16LE);
                }
            }
        }

        return new StringPool(strings);
    }

    public XmlTreeNode getXmlTreeNode(StringPool strings) throws IOException {
        this.expectType(Chunk.NODE_TYPES);

        try (XmlInputStream in = new XmlInputStream(new ByteArrayInputStream(this.data), strings)) {
            return in.readTreeNode((ChunkHeader.XmlTreeNodeHeader) this.header);
        }
    }

    private void expectType(ResourceType... types) throws IOException {
        ResourceType firstType = CollectionUtil.getFirst(this.header.getType());

        if (Arrays.binarySearch(types, firstType) >= 0) {
            return;
        }

        throw new IOException("Expected resource of type: " + Arrays.toString(types) + ", actual type: "
                + Arrays.toString(this.header.getType().toArray()));
    }
}
