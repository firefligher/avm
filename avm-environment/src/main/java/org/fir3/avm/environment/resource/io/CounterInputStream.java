package org.fir3.avm.environment.resource.io;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;

public class CounterInputStream extends BaseInputStream<InputStream> {
    @Getter
    private long count;

    public CounterInputStream(InputStream source) {
        super(source);
    }

    @Override
    public int read() throws IOException {
        int value = this.source.read();

        if (value > -1) {
            this.count++;
        }

        return value;
    }
}
