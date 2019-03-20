package org.fir3.avm.environment.resource.manifest;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class UsesConfiguration {
    @XmlAttribute(name = "package")
    private boolean reqFiveWayNav;

    @XmlAttribute(name = "package")
    private boolean reqHardKeyboard;

    @XmlAttribute(name = "package")
    private KeyboardType reqKeyboardType;

    @XmlAttribute(name = "package")
    private NavigationType reqNavigation;

    @XmlAttribute(name = "package")
    private TouchScreenType reqTouchScreen;
}
