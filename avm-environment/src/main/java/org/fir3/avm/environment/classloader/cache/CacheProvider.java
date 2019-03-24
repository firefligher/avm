package org.fir3.avm.environment.classloader.cache;

public interface CacheProvider {
    /**
     * Get the cache for the specified <code>dexData</code>.
     *
     * @param dexData The data of the dex file
     * @return
     * The corresponding cache instance to the specified <code>dexData</code>.
     */
    Cache getCache(byte[] dexData);

    /**
     * Remove any kind of cached data and start over again.
     */
    void reset();
}
