package org.fir3.avm.environment.resource;

import lombok.Data;
import lombok.extern.java.Log;
import org.fir3.avm.environment.resource.io.*;
import org.fir3.avm.environment.util.CollectionUtil;
import org.w3c.dom.Document;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Data
@Log
public class Chunk {
    private static final ResourceType[] NODE_TYPES = new ResourceType[] {
            ResourceType.XmlFirstChunk, ResourceType.XmlStartNamespace, ResourceType.XmlEndNamespace,
            ResourceType.XmlStartElement, ResourceType.XmlEndElement, ResourceType.XmlCdata
    };

    private final ChunkHeader header;
    private final byte[] data;

    public Document getDocument() throws IOException {
        this.expectType(ResourceType.Xml);

        // Deserialize the document

        DocumentGenerator docGen = new DocumentGenerator();

        try (ResourceInputStream in = new ResourceInputStream(new ByteArrayInputStream(this.data))) {
            // Variables for the reading process

            boolean expectContinuation = true;
            int depth = 0;

            // Variables for the proceeding process

            StringPool strings = null;

            while (expectContinuation) {
                Chunk chunk = in.readChunk();

                // Increase/decrease the depth depending on whether an element/namespace is starting/ending

                Set<ResourceType> types = chunk.getHeader().getResourceTypes();

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
                    docGen.proceed(chunk.getXmlTreeNode(strings), strings);
                    continue;
                }

                throw new IOException("Unexpected resource type: " + type);
            }
        }

        return docGen.getDocument();
    }

    public Table getTable() throws IOException {
        this.expectType(ResourceType.Table);

        Set<TablePackage> packages = new HashSet<>();

        try (ResourceInputStream in = new ResourceInputStream(new ByteArrayInputStream(this.data))) {
            ChunkHeader.TableHeader header = (ChunkHeader.TableHeader) this.header;
            StringPool strings = null;

            // Reading chunks as long as the package count is larger than the actual number of packages read.

            while (header.getPackageCount() > packages.size()) {
                Chunk chunk = in.readChunk();

                // Proceeding the chunk

                ResourceType type = CollectionUtil.getFirst(chunk.getHeader().getResourceTypes());

                if (type == ResourceType.StringPool) {
                    if (strings != null) {
                        throw new UnsupportedOperationException("No more than one StringPool is supported!");
                    }

                    strings = chunk.getStringPool();
                    continue;
                }

                if (type == ResourceType.TablePackage) {
                    packages.add(chunk.getTablePackage());
                    continue;
                }

                throw new IOException("Unexpected resource type: " + type);
            }
        }

        return new Table(packages);
    }

    public StringPool getStringPool() throws IOException {
        this.expectType(ResourceType.StringPool);

        try (StringInputStream in = new StringInputStream(new ByteArrayInputStream(this.data))) {
            return in.readStringPool((ChunkHeader.StringPoolHeader) this.header);
        }
    }

    public XmlTreeNode getXmlTreeNode(StringPool strings) throws IOException {
        this.expectType(Chunk.NODE_TYPES);

        try (XmlInputStream in = new XmlInputStream(new ByteArrayInputStream(this.data), strings)) {
            return in.readTreeNode((ChunkHeader.XmlTreeNodeHeader) this.header);
        }
    }

    public TablePackage getTablePackage() throws IOException {
        this.expectType(ResourceType.TablePackage);

        // Get the required information for the header

        ChunkHeader.TablePackageHeader header = (ChunkHeader.TablePackageHeader) this.header;
        long id = header.getId();
        String name = header.getName();

        // Reading the data pool

        try (CounterInputStream cIn = new CounterInputStream(new ByteArrayInputStream(this.data));
             ResourceInputStream in = new ResourceInputStream(cIn)) {
            // Read all chunks until we reached the end of the data array

            while (cIn.getCount() < this.data.length) {
                Chunk c = in.readChunk();

                if (c.getHeader().getResourceTypes().contains(ResourceType.StringPool)) {
                    System.out.println(c.getStringPool());
                }

                // TODO: Handle the chunks
            }
        }

        return new TablePackage(id, name);
    }

    private void expectType(ResourceType... types) throws IOException {
        ResourceType firstType = CollectionUtil.getFirst(this.header.getResourceTypes());

        if (Arrays.binarySearch(types, firstType) >= 0) {
            return;
        }

        throw new IOException("Expected resource of type: " + Arrays.toString(types) + ", actual type: "
                + Arrays.toString(this.header.getResourceTypes().toArray()));
    }
}
