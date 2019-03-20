package org.fir3.avm.environment.resource.manifest;

import javax.xml.bind.annotation.XmlEnumValue;

public enum ProtectionLevel {
    @XmlEnumValue("normal")
    Normal,

    @XmlEnumValue("dangerous")
    Dangerous,

    @XmlEnumValue("signature")
    Signature,

    @XmlEnumValue("signatureOrSystem")
    SignatureOrSystem
}
