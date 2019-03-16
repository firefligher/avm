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
}
