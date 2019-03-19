package org.fir3.avm.environment.resource.io;

import org.fir3.avm.environment.resource.ChunkHeader;
import org.fir3.avm.environment.resource.StringPool;
import org.fir3.avm.environment.util.StreamUtil;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringInputStream extends BaseInputStream<LEInputStream> {
    public StringInputStream(InputStream source) {
        super(new LEInputStream(source));
    }

    public StringPool readStringPool(ChunkHeader.StringPoolHeader header) throws IOException {
        // NOTE: At the moment this implementation ignores everything besides a string index and the string itself,
        //       maybe we should implement the rest in the future (if required).

        // Preconditions

        long stringCount = header.getStringCount();

        if (stringCount > Integer.MAX_VALUE) {
            throw new UnsupportedOperationException("Cannot have more strings in a string pool than a signed integer " +
                    "is large!");
        }

        int iStringCount = (int) stringCount;

        // Read the indices

        final long[] indices = new long[iStringCount];

        for (int i = 0; i < iStringCount; i++) {
            indices[i] = this.source.readUint32();
        }

        // Skip the remaining space until we reach the first string

        StreamUtil.skipFully(this.source, header.getStringsStart() - header.getHeaderSize() - iStringCount * 4);

        // Temporary sort the indices by their value, which is required to ensure that we never have to seek backwards
        // in the source stream (because this may not be supported).

        List<Integer> indicesSorted = new ArrayList<>(indices.length);

        for (int i = 0; i < indices.length; i++) {
            indicesSorted.add(i, i);
        }

        Collections.sort(indicesSorted, new Comparator<Integer>() {
            @Override
            public int compare(Integer left, Integer right) {
                return (int) (indices[left] - indices[right]);
            }
        });

        // Find out if the strings are encoded in UTF-8 or in UTF-16 (little endian)

        boolean utf8 = (header.getFlags() & ChunkHeader.StringPoolHeader.FLAG_UTF8) != 0;

        // Read the strings in the right order

        try (CounterInputStream countedIn = new CounterInputStream(this.source);
             LEInputStream in = new LEInputStream(countedIn)) {
            String[] strings = new String[iStringCount];

            for (int index : indicesSorted) {
                // Skip the padding bytes (if any)

                StreamUtil.skipFully(this.source, indices[index] - countedIn.getCount());

                // Read the string

                strings[index] = this.readString(in, utf8);
                System.out.println(index + ": " + strings[index]);
            }

            return new StringPool(strings);
        }
    }

    private String readString(LEInputStream src, boolean utf8) throws IOException {
        // Determine the length of the final string. For some reason, the format differs in encoding the length for
        // UTF-8/UTF-16 strings:
        //
        // - UTF-16:    The length is encoded in two or four bytes.
        // - UTF-8:     The length of the string as UTF-16 string is encoded in one to two bytes and after this the
        //              length of the actual UTF-8 string is also encoded in one to two bytes.

        int length;

        if (utf8) {
            // Discarding the UTF-16 length, because we do not need it in our decoding process.

            this.readUtf8Length(src);
            length = this.readUtf8Length(src);
        } else {
            length = this.readUtf16Length(src);
        }


        // Read the string's bytes from the stream

        byte[] data;

        if (utf8) {
            data = new byte[length];
        } else {
            data = new byte[length * 2];
        }

        StreamUtil.readFully(src, data);

        // Expecting one '\u0000' character

        long nullCharacter;

        if (utf8) {
            nullCharacter = src.readUint8();
        } else {
            nullCharacter = src.readUint16();
        }

        if (nullCharacter != 0x0000) {
            throw new IOException("Expected string terminator!");
        }

        // Decode the string data

        Charset charset = StandardCharsets.UTF_16LE;

        if (utf8) {
            charset = StandardCharsets.UTF_8;
        }

        return new String(data, charset);
    }

    private int readUtf8Length(LEInputStream src) throws IOException {
        int length = src.readUint8();

        if ((length & 0x80) == 0x80) {
            // MSB set, using two bytes for length

            length = (length & 0x7F) << 8 | src.readUint8();
        }

        return length;
    }

    private int readUtf16Length(LEInputStream src) throws IOException {
        int length = src.readUint16();

        if ((length & 0x8000) == 0x8000) {
            // MSB set, using four bytes for length

            length = (length & 0x7FFF) << 16 | src.readUint16();
        }

        return length;
    }
}
