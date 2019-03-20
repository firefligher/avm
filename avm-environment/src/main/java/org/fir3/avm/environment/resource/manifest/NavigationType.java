package org.fir3.avm.environment.resource.manifest;

import javax.xml.bind.annotation.XmlEnumValue;

public enum NavigationType {
    @XmlEnumValue("undefined")
    Undefined,

    @XmlEnumValue("nonav")
    NoNav,

    @XmlEnumValue("dpad")
    Dpad,

    @XmlEnumValue("trackball")
    Trackball,

    @XmlEnumValue("wheel")
    Wheel
}
