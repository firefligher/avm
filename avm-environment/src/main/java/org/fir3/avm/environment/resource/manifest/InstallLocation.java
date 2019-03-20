package org.fir3.avm.environment.resource.manifest;

import javax.xml.bind.annotation.XmlEnumValue;

public enum InstallLocation {
    @XmlEnumValue("internalOnly")
    InternalOnly,

    @XmlEnumValue("auto")
    Auto,

    @XmlEnumValue("preferExternal")
    PreferExternal
}
