package org.fir3.avm.environment.resource;

import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Data
abstract class XmlTreeNode {
    @Getter
    static class XmlTreeNamespace extends XmlTreeNode {
        private final String prefix;
        private final String uri;

        XmlTreeNamespace(long lineNumber, String comment, String prefix, String uri) {
            super(lineNumber, comment);

            this.prefix = prefix;
            this.uri = uri;
        }

        @Override
        public String toString() {
            return String.format("%s(lineNumber=%d, comment=%s, prefix=%s, uri=%s)", this.getClass().getSimpleName(),
                    this.getLineNumber(), this.getComment(), this.prefix, this.uri);
        }
    }

    @Getter
    static class XmlTreeEndElement extends XmlTreeNode {
        private final String ns;
        private final String name;

        XmlTreeEndElement(long lineNumber, String comment, String ns, String name) {
            super(lineNumber, comment);

            this.ns = ns;
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("%s(lineNumber=%d, comment=%s, ns=%s, name=%s)", this.getClass().getSimpleName(),
                    this.getLineNumber(), this.getComment(), this.ns, this.name);
        }
    }

    @Getter
    static class XmlTreeStartElement extends XmlTreeEndElement {
        private final int attributeStart;
        private final int attributeSize;
        private final int attributeCount;
        private final int idIndex;
        private final int classIndex;
        private final int styleIndex;
        private final List<XmlTreeAttribute> attributes;

        XmlTreeStartElement(long lineNumber, String comment, String ns, String name, int attributeStart,
                            int attributeSize, int attributeCount, int idIndex, int classIndex, int styleIndex,
                            List<XmlTreeAttribute> attributes) {
            super(lineNumber, comment, ns, name);

            this.attributeStart = attributeStart;
            this.attributeSize = attributeSize;
            this.attributeCount = attributeCount;
            this.idIndex = idIndex;
            this.classIndex = classIndex;
            this.styleIndex = styleIndex;
            this.attributes = attributes;
        }

        @Override
        public String toString() {
            return String.format("%s(lineNumber=%d, comment=%s, ns=%s, name=%s, attributeStart=%d, attributeSize=%d, " +
                            "attributeCount=%d, idIndex=%d, classIndex=%d, styleIndex=%d, attributes=%s)",
                    this.getClass().getSimpleName(), this.getLineNumber(), this.getComment(), this.getNs(),
                    this.getName(), this.attributeStart, this.attributeSize, this.attributeCount, this.idIndex,
                    this.classIndex, this.styleIndex, Arrays.toString(this.attributes.toArray()));
        }
    }

    private final long lineNumber;
    private final String comment;
}
