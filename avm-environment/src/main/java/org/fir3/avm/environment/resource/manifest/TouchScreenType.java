package org.fir3.avm.environment.resource.manifest;

import javax.xml.bind.annotation.XmlEnumValue;

public enum TouchScreenType {
    @XmlEnumValue("undefined")
    Undefined,

    @XmlEnumValue("notouch")
    NoTouch,

    @XmlEnumValue("stylus")
    Stylus,

    @XmlEnumValue("finger")
    Finger
}
