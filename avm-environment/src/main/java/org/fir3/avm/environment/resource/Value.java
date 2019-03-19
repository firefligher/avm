package org.fir3.avm.environment.resource;

import lombok.Data;
import org.fir3.avm.environment.util.CollectionUtil;

import java.util.Set;

@Data
public class Value {
    private final int size;
    private final short res0;
    private final Set<ValueType> dataType;
    private final long data;

    public String toString(StringPool strings) {
        ValueType type = CollectionUtil.getFirst(this.dataType);

        switch (type) {
            case NULL:
                return "";

            case REFERENCE:
                return String.format("0x%h", Long.toHexString(this.data));

            case STRING:
                return strings.getReference(this.data);

            case FIRST_INT:
            case INT_DEC:
                return String.valueOf(this.data);

            case INT_HEX:
                return Long.toHexString(this.data);

            case INT_BOOLEAN:
                return String.valueOf(this.data != 0);

            default:
                throw new UnsupportedOperationException("ValueType has not been implemented: " + type);
        }
    }
}
