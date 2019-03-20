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
public class Provider {
    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String authorities;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean enabled;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean exported;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android", name = "grantUriPermissions")
    private boolean grantUriPermissionsAttr;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    @XmlJavaTypeAdapter(HexLongAdapter.class)
    private Long icon;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private int initOrder;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    @XmlJavaTypeAdapter(HexLongAdapter.class)
    private Long label;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean multiprocess;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String name;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String permission;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String process;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String readPermission;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean syncable;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String writePermission;

    @XmlElement(name = "meta-data")
    private MetaData[] metaData;

    @XmlElement(name = "grant-uri-permission")
    private GrantUriPermission[] grantUriPermissionChildren;

    @XmlElement(name = "path-permission")
    private PathPermission[] pathPermissions;
}
