package org.fir3.avm.environment.resource.manifest;

import lombok.Data;
import org.fir3.avm.environment.resource.adapter.HexLongAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Instrumentation {
    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean functionalTest;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean handleProfiling;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    @XmlJavaTypeAdapter(HexLongAdapter.class)
    private Long icon;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    @XmlJavaTypeAdapter(HexLongAdapter.class)
    private Long label;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String name;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String targetPackage;
}
