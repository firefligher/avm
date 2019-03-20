package org.fir3.avm.environment.resource.manifest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@lombok.Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String host;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String mimeType;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String path;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String pathPattern;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String pathPrefix;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String port;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String scheme;
}
