package org.fir3.avm.environment.util;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtil {
    public static void readFully(InputStream src, byte[] dst) throws IOException {
        int offset = 0, bytes;

        while (offset < dst.length) {
            bytes = src.read(dst, offset, dst.length - offset);

            if (bytes == -1) {
                throw new EOFException();
            }

            offset += bytes;
        }
    }

    public static void skipFully(InputStream stream, long bytes) throws IOException {
        if (bytes < 0) {
            throw new IllegalArgumentException("Cannot skip backwards!");
        }

        int totalSkipped = 0, escalation = 0;

        do {
            long skipped = stream.skip(bytes);

            if (skipped == 0) {
                escalation++;
            }

            totalSkipped += skipped;

            if (escalation > 3) {
                throw new IOException("Cannot skip anymore!");
            }
        } while (totalSkipped < bytes);
    }
}
