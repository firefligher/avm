package org.fir3.avm.environment.classloader;

import org.fir3.avm.environment.classloader.cache.Cache;

public class CachedClassLoader extends ClassLoader {
    private final BinaryClassPool basePool;
    private final Cache cache;

    public CachedClassLoader(BinaryClassPool basePool, Cache cache) {
        this.basePool = basePool;
        this.cache = cache;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData;

        // Try to load the class using the cache

        classData = this.cache.getBinaryClass(name);

        if (classData != null) {
            return this.defineClass(name, classData, 0, classData.length);
        }

        // Try to load the class using the basePool and, if it succeeds, cache the class

        classData = this.basePool.getBinaryClass(name);

        if (classData != null) {
            this.cache.setBinaryClass(name, classData);
            return this.defineClass(name, classData, 0, classData.length);
        }

        // Try to resolve the class using the next ClassLoader in the hierarchy

        return super.findClass(name);
    }
}
