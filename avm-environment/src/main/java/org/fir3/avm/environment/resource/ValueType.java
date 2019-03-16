package org.fir3.avm.environment.resource;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public enum ValueType {
    NULL(0x00),
    REFERENCE(0x01),
    ATTRIBUTE(0x02),
    STRING(0x03),
    FLOAT(0x04),
    DIMENSION(0x05),
    FRACTION(0x06),
    FIRST_INT(0x10),
    INT_DEC(0x10),
    INT_HEX(0x11),
    INT_BOOLEAN(0x12),
    FIRST_COLOR_INT(0x1C),
    INT_COLOR_ARGB8(0x1C),
    INT_COLOR_RGB8(0x1D),
    INT_COLOR_ARGB4(0x1E),
    INT_COLOR_RGB4(0x1F),
    LAST_COLOR_INT(0x1F),
    LAST_INT(0x1F);

    @Getter
    private final int id;

    ValueType(int id) {
        this.id = id;
    }

    public static Set<ValueType> getTypes(int id) {
        Set<ValueType> result = new HashSet<>(2);

        for (ValueType type : ValueType.values()) {
            if (type.getId() != id) {
                continue;
            }

            result.add(type);
        }

        return result;
    }
}
