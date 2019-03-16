package org.fir3.avm.environment.resource.io;

import java.io.InputStream;

public class XmlInputStream extends BaseInputStream<LEInputStream> {
    public XmlInputStream(InputStream source) {
        super(new LEInputStream(source));
    }
}
