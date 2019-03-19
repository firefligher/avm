package org.fir3.avm.environment.resource.manifest;

import javax.xml.bind.annotation.XmlEnumValue;

public enum LaunchMode {
    @XmlEnumValue("multiple")
    Multiple,

    @XmlEnumValue("singleTop")
    SingleTop,

    @XmlEnumValue("singleTask")
    SingleTask,

    @XmlEnumValue("singleInstance")
    SingleInstance
}
