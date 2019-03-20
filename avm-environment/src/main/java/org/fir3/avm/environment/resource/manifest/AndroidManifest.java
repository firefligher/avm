package org.fir3.avm.environment.resource.manifest;

import lombok.Data;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

@Data
@XmlRootElement(name = "manifest")
@XmlAccessorType(XmlAccessType.FIELD)
public class AndroidManifest {
    public static AndroidManifest deserialize(Document src) throws JAXBException {
        JAXBContext ctx = JAXBContext.newInstance(AndroidManifest.class);
        Unmarshaller unmarshaller = ctx.createUnmarshaller();

        return unmarshaller.unmarshal(src, AndroidManifest.class).getValue();
    }

    @XmlAttribute(name = "package")
    private String _package;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String sharedUserId;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String sharedUserLabel;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private int versionCode;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private String versionName;

    @XmlAttribute(namespace = "http://schemas.android.com/apk/res/android")
    private InstallLocation location;

    @XmlElement(required = true)
    private Application application;

    @XmlElement(name = "instrumentation")
    private Instrumentation[] instrumentations;

    @XmlElement(name = "permission")
    private Permission[] permissions;

    @XmlElement(name = "permission-group")
    private PermissionGroup[] permissionGroups;

    @XmlElement(name = "permission-tree")
    private PermissionTree[] permissionTrees;

    @XmlElement(name = "uses-configuration")
    private UsesConfiguration[] usesConfigurations;

    @XmlElement(name = "uses-permission")
    private UsesPermission[] usesPermissions;

    @XmlElement(name = "uses-sdk")
    private UsesSdk[] usesSdks;
}
