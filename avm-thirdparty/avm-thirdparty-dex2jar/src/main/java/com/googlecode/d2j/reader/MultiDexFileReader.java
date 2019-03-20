package com.googlecode.d2j.reader;

import com.googlecode.d2j.DexConstants;
import com.googlecode.d2j.visitors.DexFileVisitor;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MultiDexFileReader implements BaseDexFileReader {
    public static MultiDexFileReader from(InputStream... streams) throws IOException {
        DexFileReader[] readers = new DexFileReader[streams.length];

        for (int i = 0; i < readers.length; i++) {
            readers[i] = new DexFileReader(streams[i]);
        }

        return new MultiDexFileReader(Arrays.asList(readers));
    }

    final private List<DexFileReader> readers = new ArrayList<>();
    final private List<Item> items = new ArrayList<>();

    public MultiDexFileReader(Collection<DexFileReader> readers) {
        this.readers.addAll(readers);
        init();
    }

    void init() {
        Set<String> classes = new HashSet<>();
        for (DexFileReader reader : readers) {
            List<String> classNames = reader.getClassNames();
            for (int i = 0; i < classNames.size(); i++) {
                String className = classNames.get(i);
                if (classes.add(className)) {
                    items.add(new Item(i, reader, className));
                }
            }
        }
    }

    @Override
    public int getDexVersion() {
        int max = DexConstants.DEX_035;
        for (DexFileReader r : readers) {
            int v = r.getDexVersion();
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    @Override
    public void accept(DexFileVisitor dv) {
        accept(dv, 0);
    }

    @Override
    public List<String> getClassNames() {
        return new AbstractList<String>() {
            @Override
            public String get(int index) {
                return items.get(index).className;
            }

            @Override
            public int size() {
                return items.size();
            }
        };
    }

    @Override
    public void accept(DexFileVisitor dv, int config) {
        int size = items.size();
        for (int i = 0; i < size; i++) {
            accept(dv, i, config);
        }
    }

    @Override
    public void accept(DexFileVisitor dv, int classIdx, int config) {
        Item item = items.get(classIdx);
        item.reader.accept(dv, item.idx, config);
    }

    static class Item {
        int idx;
        DexFileReader reader;
        String className;

        public Item(int i, DexFileReader reader, String className) {
            idx = i;
            this.reader = reader;
            this.className = className;
        }
    }
}
