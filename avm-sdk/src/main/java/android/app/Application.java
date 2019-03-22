package android.app;

import android.content.ComponentCallbacks2;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Bundle;
import lombok.extern.java.Log;

@Log
public class Application extends ContextWrapper implements ComponentCallbacks2 {
    public interface ActivityLifecycleCallbacks {
        void onActivityCreated(Activity activity, Bundle savedInstanceState);

        void onActivityDestroyed(Activity activity);

        void onActivityPaused(Activity activity);

        void onActivityPostCreated(Activity activity, Bundle savedInstanceState);

        void onActivityPostDestroyed(Activity activity);

        void onActivityPostPaused(Activity activity);

        void onActivityPostResumed(Activity activity);

        void onActivityPostSaveInstanceState(Activity activity, Bundle outState);

        void onActivityPostStarted(Activity activity);

        void onActivityPostStopped(Activity activity);

        void onActivityPreCreated(Activity activity, Bundle savedInstanceState);

        void onActivityPreDestroyed(Activity activity);

        void onActivityPrePaused(Activity activity);

        void onActivityPreResumed(Activity activity);

        void onActivityPreSaveInstanceState(Activity activity, Bundle outState);

        void onActivityPreStarted(Activity activity);

        void onActivityPreStopped(Activity activity);

        void onActivityResumed(Activity activity);

        void onActivitySaveInstanceState(Activity activity, Bundle outState);

        void onActivityStarted(Activity activity);

        void onActivityStopped(Activity activity);
    }

    public interface OnProvideAssistDataListener {
        void onProvideAssistData(Activity activity, Bundle data);
    }

    public static String getProcessName() {
        log.warning("Unimplemented method: android.app.Application.getProcessName()");
        return null;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        log.warning("Unimplemented method: android.app.Application.onConfigurationChanged(" +
                "android.content.res.Configuration)");
    }

    public void onCreate() {
        log.warning("Unimplemented method: android.app.Application.onCreate()");
    }

    @Override
    public void onLowMemory() {
        log.warning("Unimplemented method: android.app.Application.onLowMemory()");
    }

    public void onTerminate() {
        log.warning("Unimplemented method: android.app.Application.onTerminate()");
    }

    @Override
    public void onTrimMemory(int level) {
        log.warning("Unimplemented method: android.app.Application.onTrimMemory(int)");
    }

    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        log.warning("Unimplemented method: android.app.Application.registerActivityLifecycleCallbacks(" +
                "android.app.Application$ActivityLifecycleCallbacks)");
    }

    public void registerOnProvideAssistDataListener(OnProvideAssistDataListener callback) {
        log.warning("Unimplemented method: android.app.Application.registerOnProvideAssistDataListener(" +
                "android.app.Application$OnProvideAssistDataListener)");
    }

    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        log.warning("Unimplemented method: android.app.Application.unregisterActivityLifecycleCallbacks(" +
                "android.app.Application$ActivityLifecycleCallbacks)");
    }

    public void unregisterOnProvideAssistDataListener(OnProvideAssistDataListener callback) {
        log.warning("Unimplemented method: android.app.Application.unregisterOnProvideAssistDataListener(" +
                "android.app.Application$ActivityLifecycleCallbacks)");
    }
}
