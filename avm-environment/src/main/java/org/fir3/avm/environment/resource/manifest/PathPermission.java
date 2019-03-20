package org.fir3.avm.environment.resource.manifest;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class PathPermission {
    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String path;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String pathPrefix;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String pathPattern;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String permission;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String readPermission;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String writePermission;
}
