package org.fir3.avm.environment.resource;

import lombok.Data;

@Data
public class XmlTreeAttribute {
    private final String ns;
    private final String name;
    private final String rawValue;
    private final Value typedValue;
}
