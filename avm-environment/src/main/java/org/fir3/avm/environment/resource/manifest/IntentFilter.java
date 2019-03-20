package org.fir3.avm.environment.resource.manifest;

import lombok.Data;
import org.fir3.avm.environment.resource.adapter.HexLongAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class IntentFilter {
    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    @XmlJavaTypeAdapter(HexLongAdapter.class)
    private Long icon;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    @XmlJavaTypeAdapter(HexLongAdapter.class)
    private Long label;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private int priority;

    @XmlElement(name = "action")
    private Action[] actions;

    @XmlElement(name = "category")
    private Category[] categories;

    @XmlElement(name = "data")
    private org.fir3.avm.environment.resource.manifest.Data[] data;
}
