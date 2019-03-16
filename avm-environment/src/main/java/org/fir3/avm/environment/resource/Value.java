package org.fir3.avm.environment.resource;

import lombok.Data;

import java.util.Set;

@Data
public class Value {
    private final int size;
    private final short res0;
    private final Set<ValueType> dataType;
    private final long data;
}
