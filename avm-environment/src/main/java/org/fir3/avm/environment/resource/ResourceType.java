package org.fir3.avm.environment.resource;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public enum ResourceType {
    Null(0x0000),
    StringPool(0x0001),
    Table(0x0002),
    Xml(0x0003),

    XmlFirstChunk(0x0100),
    XmlStartNamespace(0x0100),
    XmlEndNamespace(0x0101),
    XmlStartElement(0x0102),
    XmlEndElement(0x0103),
    XmlCdata(0x0104),
    XmlLastChunk(0x017F),
    XmlResourceMap(0x0180),

    TablePackage(0x0200),
    TableType(0x0201),
    TableTypeSpec(0x0202);

    @Getter
    private final int id;

    ResourceType(int id) {
        this.id = id;
    }

    public static Set<ResourceType> getTypes(int id) {
        Set<ResourceType> result = new HashSet<>(2);

        for (ResourceType type : ResourceType.values()) {
            if (type.getId() != id) {
                continue;
            }

            result.add(type);
        }

        return result;
    }
}
