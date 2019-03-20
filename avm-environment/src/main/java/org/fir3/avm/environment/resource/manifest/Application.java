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
public class Application {
    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean allowTaskReparenting;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String backupAgent;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean debuggable;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    @XmlJavaTypeAdapter(HexLongAdapter.class)
    private Long description;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean enabled;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean hasCode;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean hardwareAccelerated;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    @XmlJavaTypeAdapter(HexLongAdapter.class)
    private Long icon;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean killAfterRestore;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean largeHeap;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    @XmlJavaTypeAdapter(HexLongAdapter.class)
    private Long label;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    @XmlJavaTypeAdapter(HexLongAdapter.class)
    private Long logo;

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

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    @XmlJavaTypeAdapter(HexLongAdapter.class)
    private Long theme;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private UiOptions uiOptions;

    @XmlElement(name = "activity")
    private Activity[] activities;

    @XmlElement(name = "activity-atlas")
    private ActivityAtlas[] activityAtlases;

    @XmlElement(name = "service")
    private Service[] services;

    @XmlElement(name = "receiver")
    private Receiver[] receivers;

    @XmlElement(name = "provider")
    private Provider[] providers;

    @XmlElement(name = "uses-library")
    private UsesLibrary[] usesLibraries;
}
