package org.fir3.avm.environment.resource.manifest;

import javax.xml.bind.annotation.XmlEnumValue;

public enum ScreenOrientation {
    @XmlEnumValue("unspecified")
    Unspecified,

    @XmlEnumValue("user")
    User,

    @XmlEnumValue("behind")
    Behind,

    @XmlEnumValue("landscape")
    Landscape,

    @XmlEnumValue("portrait")
    Portrait,

    @XmlEnumValue("reverseLandscape")
    ReverseLandscape,

    @XmlEnumValue("reversePortrait")
    ReversePortrait,

    @XmlEnumValue("sensorLandscape")
    SensorLandscape,

    @XmlEnumValue("sensorPortrait")
    SensorPortrait,

    @XmlEnumValue("sensor")
    Sensor,

    @XmlEnumValue("fullSensor")
    FullSensor,

    @XmlEnumValue("nosensor")
    NoSensor
}
