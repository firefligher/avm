package org.fir3.avm.environment.util;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

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

    public static String readFixedString(InputStream src, int byteLength, Charset charset, boolean escaped)
            throws IOException {
        byte[] encodedData = new byte[byteLength];
        StreamUtil.readFully(src, encodedData);

        // Determine the length, if escaped

        int length = encodedData.length;

        if (escaped) {
            byte[] needle = null;

            if (charset == StandardCharsets.US_ASCII || charset == StandardCharsets.UTF_8) {
                needle = new byte[] { 0x00 };
            }

            if (charset == StandardCharsets.UTF_16 || charset == StandardCharsets.UTF_16LE ||
                    charset == StandardCharsets.UTF_16BE) {
                needle = new byte[] { 0x00, 0x00 };
            }

            // If no needle was initialized, there is no support for escaping with the specified charset

            if (needle == null) {
                throw new IllegalArgumentException("Charset is not supported for escaping: " + charset.name());
            }

            // Find the escape sequence

            length = StreamUtil.indexOf(encodedData, needle);

            if (length == -1) {
                throw new IOException("No escape sequence found!");
            }
        }

        return new String(encodedData, 0, length, charset);
    }

    private static int indexOf(byte[] haystack, byte[] needle) {
        for (int i = 0; i < haystack.length; i += needle.length) {
            boolean match = true;

            for (int j = 0; j < needle.length; j++) {
                if (haystack[i + j] == needle[j]) {
                    continue;
                }

                match = false;
                break;
            }

            if (!match) {
                continue;
            }

            return i;
        }

        return -1;
    }
}
