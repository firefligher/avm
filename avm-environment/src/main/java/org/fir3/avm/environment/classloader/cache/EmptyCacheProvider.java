package org.fir3.avm.environment.classloader.cache;

public final class EmptyCacheProvider implements CacheProvider {
    public static final EmptyCacheProvider INSTANCE = new EmptyCacheProvider();

    private static Cache EMPTY_CACHE = new Cache() {
        @Override
        public byte[] getBinaryClass(String className) {
            return null;
        }

        @Override
        public void setBinaryClass(String className, byte[] data) { }
    };

    private EmptyCacheProvider() { }

    @Override
    public Cache getCache(byte[] dexData) {
        return EmptyCacheProvider.EMPTY_CACHE;
    }

    @Override
    public void reset() { }
}
