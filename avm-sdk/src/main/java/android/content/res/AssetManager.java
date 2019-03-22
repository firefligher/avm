package android.content.res;

import lombok.extern.java.Log;

@Log
public final class AssetManager implements AutoCloseable {
    @Override
    public void close() {
        log.warning("Unimplemented method: android.content.res.AssetManager.close()");
    }
}
