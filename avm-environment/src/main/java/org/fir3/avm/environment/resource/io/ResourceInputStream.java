package org.fir3.avm.environment.resource.io;

import org.fir3.avm.environment.resource.*;
import org.fir3.avm.environment.util.CollectionUtil;
import org.fir3.avm.environment.util.StreamUtil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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

        Set<ResourceType> types = IdProvider.Util.find(ResourceType.values(), typeId);

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

            case TablePackage:
                long id = this.source.readUint32();
                String name = StreamUtil.readFixedString(this.source, 256, StandardCharsets.UTF_16LE, true);
                long typeStrings = this.source.readUint32();
                long lastPublicType = this.source.readUint32();
                long keyStrings = this.source.readUint32();
                long lastPublicKey = this.source.readUint32();

                return new ChunkHeader.TablePackageHeader(types, headerSize, size, id, name, typeStrings,
                        lastPublicType, keyStrings, lastPublicKey);

            case TableTypeSpec:
            case TableType:
                short id_u8 = this.source.readUint8();
                short res0 = this.source.readUint8();
                int res1 = this.source.readUint16();
                long entryCount = this.source.readUint32();

                // Validation (according to the specification in the ResourceTypes.h)

                if (id_u8 < 1) {
                    throw new IOException("Illegal id value (id < 1): " + id_u8);
                }

                if (res0 != 0 || res1 != 0) {
                    throw new IOException("Illegal reserved value (not 0)!");
                }

                if (type == ResourceType.TableTypeSpec) {
                    return new ChunkHeader.TableTypeSpecHeader(types, headerSize, size, id_u8, res0, res1, entryCount);
                }

                // Read the remaining to get a full TableType

                long entriesStart = this.source.readUint32();
                TableConfig config = this.readTableConfig();

                return new ChunkHeader.TableTypeHeader(types, headerSize, size, id_u8, res0, res1, entryCount,
                        entriesStart, config);

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
        Set<ValueType> dataType = IdProvider.Util.find(ValueType.values(), this.source.readUint8());
        long data = this.source.readUint32();

        return new Value(size, res0, dataType, data);
    }

    public TableConfig readTableConfig() throws IOException {
        // Read and validate the size

        long size = this.source.readUint32();

        if (size > Integer.MAX_VALUE) {
            throw new UnsupportedOperationException("Size exceeds signed integer limit: " + size);
        }

        // Read the bytes into a byte array and use it as source to ensure the observance of the size boundary

        byte[] data = new byte[(int) size];
        StreamUtil.readFully(this.source, data);

        try (LEInputStream in = new LEInputStream(new ByteArrayInputStream(data))) {
            // Read the IMSI

            int mcc = in.readUint16();
            int mnc = in.readUint16();

            TableConfig.Imsi imsi = new TableConfig.Imsi(mcc, mnc);

            // Read the locale

            String language = StreamUtil.readFixedString(in, 2, StandardCharsets.US_ASCII, false);
            String country = StreamUtil.readFixedString(in, 2, StandardCharsets.US_ASCII, false);

            TableConfig.Locale locale = new TableConfig.Locale(language, country);

            // Read the screenType

            TableConfig.OrientationType orientation = IdProvider.Util.findOne(TableConfig.OrientationType.values(),
                    in.readUint8());

            TableConfig.TouchscreenType touchscreen = IdProvider.Util.findOne(TableConfig.TouchscreenType.values(),
                    in.readUint8());

            TableConfig.DensityType density = IdProvider.Util.findOne(TableConfig.DensityType.values(),
                    in.readUint16());

            TableConfig.ScreenType screenType = new TableConfig.ScreenType(orientation, touchscreen, density);

            // Read the input

            TableConfig.KeyboardType keyboard = IdProvider.Util.findOne(TableConfig.KeyboardType.values(),
                    in.readUint8());

            TableConfig.NavigationType navigation = IdProvider.Util.findOne(TableConfig.NavigationType.values(),
                    in.readUint8());

            Set<TableConfig.InputType> inputFlags = IdProvider.Util.find(TableConfig.InputType.values(),
                    in.readUint8());

            short inputPad0 = in.readUint8();

            TableConfig.Input input = new TableConfig.Input(keyboard, navigation, inputFlags, inputPad0);

            // Read the screenSize

            int screenWidth = in.readUint16();
            int screenHeight = in.readUint16();

            TableConfig.ScreenSize screenSize = new TableConfig.ScreenSize(screenWidth, screenHeight);

            // Read the version

            int sdkVersion = in.readUint16();
            int minorVersion = in.readUint16();

            TableConfig.Version version = new TableConfig.Version(sdkVersion, minorVersion);

            // Read the screenConfig

            Set<TableConfig.ScreenLayoutType> screenLayout = IdProvider.Util.find(TableConfig.ScreenLayoutType.values(),
                    in.readUint8());

            Set<TableConfig.UiModeType> uiMode = IdProvider.Util.find(TableConfig.UiModeType.values(), in.readUint8());
            int smallestScreenWidthDp = in.readUint16();

            TableConfig.ScreenConfig screenConfig = new TableConfig.ScreenConfig(screenLayout, uiMode,
                    smallestScreenWidthDp);

            // Read the screenSizeDp

            int screenWidthDp = in.readUint16();
            int screenHeightDp = in.readUint16();

            TableConfig.ScreenSizeDp screenSizeDp = new TableConfig.ScreenSizeDp(screenWidthDp, screenHeightDp);

            // Construct the TableConfig instance

            return new TableConfig(size, imsi, locale, screenType, input, screenSize, version, screenConfig,
                    screenSizeDp);
        }
    }
}
