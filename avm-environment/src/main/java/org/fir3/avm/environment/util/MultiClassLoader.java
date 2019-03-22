package org.fir3.avm.environment.util;

import java.util.HashSet;
import java.util.Set;

public class MultiClassLoader extends ClassLoader {
    private final Set<ClassLoader> children;

    public MultiClassLoader() {
        this.children = new HashSet<>();
    }

    public void addChild(ClassLoader child) {
        this.children.add(child);
    }

    @Override
    protected Class<?> findClass(final String name) throws ClassNotFoundException {
        for (ClassLoader child : this.children) {
            try {
                return child.loadClass(name);
            } catch (ClassNotFoundException ignored) { }
        }

        return super.findClass(name);
    }
}
