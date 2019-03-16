package org.fir3.avm.environment.resource.io;

import org.fir3.avm.environment.resource.Chunk;
import org.fir3.avm.environment.resource.ChunkHeader;
import org.fir3.avm.environment.resource.ResourceType;
import org.fir3.avm.environment.util.CollectionUtil;
import org.fir3.avm.environment.util.StreamUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class ResourceInputStream extends InputStream {
    private final LEInputStream source;

    public ResourceInputStream(InputStream src) {
        this.source = new LEInputStream(src);
    }

    @Override
    public int read() throws IOException {
        return this.source.read();
    }

    private ChunkHeader readChunkHeader() throws IOException {
        // Read the common header fields

        int typeId = this.source.readUint16();
        int headerSize = this.source.readUint16();
        long size = this.source.readUint32();

        Set<ResourceType> types = ResourceType.getTypes(typeId);

        if (types.isEmpty()) {
            throw new IOException("Invalid resource type id: " + typeId);
        }

        // Read the type-specific header fields

        ResourceType type = CollectionUtil.getFirst(types);
        ChunkHeader result;

        switch (type) {
            case Null:
                result = new ChunkHeader.NullHeader(types, headerSize, size);
                break;

            case StringPool:
                long stringCount = this.source.readUint32();
                long styleCount = this.source.readUint32();
                long flags = this.source.readUint32();
                long stringsStart = this.source.readUint32();
                long stylesStart = this.source.readUint32();

                result = new ChunkHeader.StringPoolHeader(types, headerSize, size, stringCount, styleCount, flags,
                        stringsStart, stylesStart);
                break;

            case Xml:
            case XmlResourceMap:
                result = new ChunkHeader.XmlTreeHeader(types, headerSize, size);
                break;

            case XmlCdata:
            case XmlFirstChunk:
            case XmlStartNamespace:
            case XmlEndNamespace:
            case XmlStartElement:
            case XmlEndElement:
                long lineNumber = this.source.readUint32();
                long comment = this.source.readUint32();

                result = new ChunkHeader.XmlTreeNodeHeader(types, headerSize, size, lineNumber, comment);
                break;

            default:
                throw new UnsupportedOperationException("Unsupported type: " + type);
        }

        return result;
    }

    public Chunk readChunk() throws IOException {
        // First, read the chunk header

        ChunkHeader header = this.readChunkHeader();

        // Read the chunk's content into a byte array.
        //
        // NOTE: The header's getSize() function always returns the chunk's size including the size of the header
        //       itself.

        long dataSize = header.getSize() - header.getHeaderSize();

        if (dataSize > Integer.MAX_VALUE) {
            throw new UnsupportedOperationException("Chunk exceeds signed integer limit: " + dataSize);
        }

        byte[] data = new byte[(int) dataSize];
        StreamUtil.readFully(this.source, data);

        // Construct the final chunk

        return new Chunk(header, data);
    }
}
