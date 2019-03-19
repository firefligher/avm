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
public class Activity {
    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean allowTaskReparenting;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean alwaysRetainTaskState;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean clearTaskOnLaunch;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String configChanges;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean enabled;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean excludeFromRecents;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean exported;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean finishOnTaskLaunch;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean hardwareAccelerated;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    @XmlJavaTypeAdapter(HexLongAdapter.class)
    private Long icon;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    @XmlJavaTypeAdapter(HexLongAdapter.class)
    private Long label;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private LaunchMode launchMode;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean multiprocess;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String name;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean noHistory;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String parentActivityName;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String permission;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String process;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private ScreenOrientation screenOrientation;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private boolean stateNotNeeded;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String taskAffinity;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    @XmlJavaTypeAdapter(HexLongAdapter.class)
    private Long theme;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private UiOptions uiOptions;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String windowSoftInputMode;

    @XmlElement(name = "intent-filter")
    private IntentFilter[] intentFilters;

    @XmlElement(name = "meta-data")
    private MetaData[] metaData;
}
