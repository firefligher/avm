package org.fir3.avm.environment.resource.manifest;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Instrumentation {
    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean functionalTest;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean handleProfiling;

    // TODO: Implement the remaining properties
}
