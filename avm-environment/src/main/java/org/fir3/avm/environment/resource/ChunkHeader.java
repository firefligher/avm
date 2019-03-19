package org.fir3.avm.environment.resource;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

@Data
public abstract class ChunkHeader implements ResourceTypeProvider {
    public static class NullHeader extends ChunkHeader {
        public NullHeader(Set<ResourceType> type, int headerSize, long size) {
            super(type, headerSize, size);
        }

        @Override
        public String toString() {
            return String.format("%s(type=%s, headerSize=%d, size=%d)", this.getClass().getSimpleName(),
                    Arrays.toString(this.getResourceTypes().toArray()), this.getHeaderSize(), this.getSize());
        }
    }

    public static class XmlTreeHeader extends ChunkHeader {
        public XmlTreeHeader(Set<ResourceType> type, int headerSize, long size) {
            super(type, headerSize, size);
        }

        @Override
        public String toString() {
            return String.format("%s(type=%s, headerSize=%d, size=%d)", this.getClass().getSimpleName(),
                    Arrays.toString(this.getResourceTypes().toArray()), this.getHeaderSize(), this.getSize());
        }
    }

    @Getter
    public static class XmlTreeNodeHeader extends ChunkHeader {
        private final long lineNumber;
        private final long comment;

        public XmlTreeNodeHeader(Set<ResourceType> type, int headerSize, long size, long lineNumber, long comment) {
            super(type, headerSize, size);

            this.lineNumber = lineNumber;
            this.comment = comment;
        }

        @Override
        public String toString() {
            return String.format("%s(type=%s, headerSize=%d, size=%d, lineNumber=%d, comment=%d)",
                    this.getClass().getSimpleName(), Arrays.toString(this.getResourceTypes().toArray()),
                    this.getHeaderSize(), this.getSize(), this.lineNumber, this.comment);
        }
    }

    @Getter
    public static class StringPoolHeader extends ChunkHeader {
        public static final long FLAG_SORTED    = 0b00000000_00000000_00000000_00000001;
        public static final long FLAG_UTF8      = 0b00000000_00000000_00000001_00000000;

        private final long stringCount;
        private final long styleCount;
        private final long flags;
        private final long stringsStart;
        private final long stylesStart;

        public StringPoolHeader(Set<ResourceType> type, int headerSize, long size, long stringCount, long styleCount,
                                long flags, long stringsStart, long stylesStart) {
            super(type, headerSize, size);

            this.stringCount = stringCount;
            this.styleCount = styleCount;
            this.flags = flags;
            this.stringsStart = stringsStart;
            this.stylesStart = stylesStart;
        }

        @Override
        public String toString() {
            return String.format("%s(type=%s, headerSize=%d, size=%d, stringCount=%d, styleCount=%d, flags=%d, " +
                            "stringsStart=%d, stylesStart=%d)",
                    this.getClass().getSimpleName(), Arrays.toString(this.getResourceTypes().toArray()),
                    this.getHeaderSize(), this.getSize(), this.stringCount, this.styleCount, this.flags,
                    this.stringsStart, this.stylesStart);
        }
    }

    @Getter
    public static class TableHeader extends ChunkHeader {
        private final long packageCount;

        public TableHeader(Set<ResourceType> type, int headerSize, long size, long packageCount) {
            super(type, headerSize, size);
            this.packageCount = packageCount;
        }

        @Override
        public String toString() {
            return String.format("%s(type=%s, headerSize=%d, size=%d, packageCount=%d)",
                    this.getClass().getSimpleName(), Arrays.toString(this.getResourceTypes().toArray()),
                    this.getHeaderSize(), this.getSize(), this.packageCount);
        }
    }

    @Getter(value = AccessLevel.NONE)
    private final Set<ResourceType> type;
    private final int headerSize;
    private final long size;

    @Override
    public Set<ResourceType> getResourceTypes() {
        return Collections.unmodifiableSet(this.type);
    }
}
