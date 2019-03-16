package org.fir3.avm.environment.resource.io;

import org.fir3.avm.environment.resource.ChunkHeader;
import org.fir3.avm.environment.resource.StringPool;
import org.fir3.avm.environment.util.StreamUtil;

import java.io.IOException;
import java.io.InputStream;
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

        // Read the strings in the right order

        try (CounterInputStream countedIn = new CounterInputStream(this.source);
             LEInputStream in = new LEInputStream(countedIn)) {
            String[] strings = new String[iStringCount];

            for (int index : indicesSorted) {
                // Skip the padding bytes (if any)

                StreamUtil.skipFully(this.source, indices[index] - countedIn.getCount());

                // Determine the length of the final string

                int length = in.readUint16();

                if ((length & 0x8000) == 0x8000) {
                    length &= 0x7FFF;
                    length <<= 16;
                    length |= in.readUint16();
                }

                // Read the string's bytes from the stream (UTF-16 encoded)

                byte[] data = new byte[length * 2];
                StreamUtil.readFully(in, data);

                // Expecting two zero bytes

                if (in.readUint16() != 0x0000) {
                    throw new IOException("Expected string terminator!");
                }

                // Decode the string data

                strings[index] = new String(data, StandardCharsets.UTF_16LE);
            }

            return new StringPool(strings);
        }
    }
}
