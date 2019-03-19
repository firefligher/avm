package org.fir3.avm.environment.resource.manifest;

import javax.xml.bind.annotation.XmlEnumValue;

public enum KeyboardType {
    @XmlEnumValue("undefined")
    Undefined,

    @XmlEnumValue("nokeys")
    NoKeys,

    @XmlEnumValue("qwerty")
    Qwerty,

    @XmlEnumValue("twelvekey")
    TwelveKey
}
