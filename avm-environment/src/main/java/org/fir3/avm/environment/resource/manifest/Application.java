package org.fir3.avm.environment.resource.manifest;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Application {
    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean allowTaskReparenting;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String backupAgent;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean debuggable;

    // TODO:
    // @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    // private String description;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean enabled;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean hasCode;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean hardwareAccelerated;

    // TODO:
    // @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    // private boolean icon;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean killAfterRestore;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean largeHeap;

    // TODO:
    // @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    // private String label;

    // TODO:
    // @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    // private String resource;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String manageSpaceActivity;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String name;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String permission;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean persistent;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String process;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean restoreAnyVersion;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean supportsRtl;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String taskAffinity;

    // TODO:
    // @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    // private String theme;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private UiOptions uiOptions;
}
