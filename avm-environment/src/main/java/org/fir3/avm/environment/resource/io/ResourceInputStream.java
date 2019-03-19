package org.fir3.avm.environment.resource.io;

import org.fir3.avm.environment.resource.*;
import org.fir3.avm.environment.util.CollectionUtil;
import org.fir3.avm.environment.util.StreamUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class ResourceInputStream extends BaseInputStream<LEInputStream> {
    public ResourceInputStream(InputStream src) {
        super(new LEInputStream(src));
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

        switch (type) {
            case Null:
                return new ChunkHeader.NullHeader(types, headerSize, size);

            case StringPool:
                long stringCount = this.source.readUint32();
                long styleCount = this.source.readUint32();
                long flags = this.source.readUint32();
                long stringsStart = this.source.readUint32();
                long stylesStart = this.source.readUint32();

                return new ChunkHeader.StringPoolHeader(types, headerSize, size, stringCount, styleCount, flags,
                        stringsStart, stylesStart);

            case Xml:
            case XmlResourceMap:
                return new ChunkHeader.XmlTreeHeader(types, headerSize, size);

            case XmlCdata:
            case XmlFirstChunk:
            case XmlStartNamespace:
            case XmlEndNamespace:
            case XmlStartElement:
            case XmlEndElement:
                long lineNumber = this.source.readUint32();
                long comment = this.source.readUint32();

                return new ChunkHeader.XmlTreeNodeHeader(types, headerSize, size, lineNumber, comment);

            case Table:
                long packageCount = this.source.readUint32();

                return new ChunkHeader.TableHeader(types, headerSize, size, packageCount);

            default:
                throw new UnsupportedOperationException("Unsupported type: " + type);
        }
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

    public Value readValue() throws IOException {
        int size = this.source.readUint16();
        short res0 = this.source.readUint8();
        Set<ValueType> dataType = ValueType.getTypes(this.source.readUint8());
        long data = this.source.readUint32();

        return new Value(size, res0, dataType, data);
    }
}
