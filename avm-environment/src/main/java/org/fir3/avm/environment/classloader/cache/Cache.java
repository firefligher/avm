package org.fir3.avm.environment.classloader.cache;

import org.fir3.avm.environment.classloader.BinaryClassPool;

public interface Cache extends BinaryClassPool {
    /**
     * Cache the <code>data</code> (JVM format) of the class with the specified <code>className</code>.
     *
     * @param className The name of the cached class
     * @param data      The data of the cached class
     */
    void setBinaryClass(String className, byte[] data);
}
