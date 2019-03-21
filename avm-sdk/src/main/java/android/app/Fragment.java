package android.app;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.view.View;
import lombok.extern.java.Log;

@Log
public class Fragment implements ComponentCallbacks2, View.OnCreateContextMenuListener {
    @Override
    public void onTrimMemory(int level) {
        log.warning("Unimplemented method: android.app.Fragment.onTrimMemory(int)");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        log.warning("Unimplemented method: android.app.Fragment.onConfigurationChanged(" +
                "android.content.res.Configuration)");
    }

    @Override
    public void onLowMemory() {
        log.warning("Unimplemented method: android.app.Fragment.onLowMemory()");
    }
}
