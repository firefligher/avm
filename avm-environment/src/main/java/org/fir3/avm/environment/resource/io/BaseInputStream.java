package org.fir3.avm.environment.resource.io;

import java.io.IOException;
import java.io.InputStream;

abstract class BaseInputStream<SourceInputStream extends InputStream> extends InputStream {
    final SourceInputStream source;

    BaseInputStream(SourceInputStream source) {
        this.source = source;
    }

    @Override
    public int read() throws IOException {
        return this.source.read();
    }

    @Override
    public void close() throws IOException {
        this.source.close();
        super.close();
    }
}
