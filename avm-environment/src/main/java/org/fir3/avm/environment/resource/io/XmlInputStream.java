package org.fir3.avm.environment.resource.io;

import org.fir3.avm.environment.resource.*;
import org.fir3.avm.environment.util.CollectionUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class XmlInputStream extends BaseInputStream<LEInputStream> {
    private final StringPool strings;

    public XmlInputStream(InputStream source, StringPool strings) {
        super(new LEInputStream(source));
        this.strings = strings;
    }

    public XmlTreeNode readTreeNode(ChunkHeader.XmlTreeNodeHeader header) throws IOException {
        // Get the common information from the header

        Set<ResourceType> types = header.getResourceTypes();
        long lineNumber = header.getLineNumber();
        String comment = this.strings.getReference(header.getComment());

        // Definitions of fields that will be used in different cases of the switch block

        String ns, name;

        switch (CollectionUtil.getFirst(types)) {
            case XmlFirstChunk:
            case XmlStartNamespace:
            case XmlEndNamespace:
                String prefix = this.strings.getReference(this.source.readUint32());
                String uri = this.strings.getReference(this.source.readUint32());

                return new XmlTreeNode.XmlTreeNamespace(types, lineNumber, comment, prefix, uri);

            case XmlStartElement:
                ns = this.strings.getReference(this.source.readUint32());
                name = this.strings.getReference(this.source.readUint32());
                int attributeStart = this.source.readUint16();
                int attributeSize = this.source.readUint16();
                int attributeCount = this.source.readUint16();
                int idIndex = this.source.readUint16();
                int classIndex = this.source.readUint16();
                int styleIndex = this.source.readUint16();

                // Decode the attributes

                List<XmlTreeAttribute> attributes = new ArrayList<>(attributeCount);

                for (int i = 0; i < attributeCount; i++) {
                    attributes.add(i, this.readTreeAttribute());
                }

                return new XmlTreeNode.XmlTreeStartElement(types, lineNumber, comment, ns, name, attributeStart,
                        attributeSize, attributeCount, idIndex, classIndex, styleIndex, attributes);

            case XmlEndElement:
                ns = this.strings.getReference(this.source.readUint32());
                name = this.strings.getReference(this.source.readUint32());

                return new XmlTreeNode.XmlTreeEndElement(types, lineNumber, comment, ns, name);

            default:
                throw new IOException("Unexpected resource type(s): " + Arrays.toString(types.toArray()));
        }
    }

    public XmlTreeAttribute readTreeAttribute() throws IOException {
        String ns = this.strings.getReference(this.source.readUint32());
        String name = this.strings.getReference(this.source.readUint32());
        String rawValue = this.strings.getReference(this.source.readUint32());

        Value typedValue;

        try (ResourceInputStream in = new ResourceInputStream(this.source)) {
            typedValue = in.readValue();
        }

        return new XmlTreeAttribute(ns, name, rawValue, typedValue);
    }
}
