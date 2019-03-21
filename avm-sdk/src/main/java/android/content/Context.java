package android.content;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.drawable.Drawable;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.*;
import android.util.AttributeSet;
import android.view.Display;
import lombok.extern.java.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.Executor;

@Log
public abstract class Context {
    public static final String ACCESSIBILITY_SERVICE = "accessibility";
    public static final String ACCOUNT_SERVICE                  = "account";
    public static final String ACTIVITY_SERVICE                 = "activity";
    public static final String ALARM_SERVICE                    = "alarm";
    public static final String APPWIDGET_SERVICE                = "appwidget";
    public static final String APP_OPS_SERVICE                  = "appops";
    public static final String AUDIO_SERVICE                    = "audio";
    public static final String BATTERY_SERVICE                  = "batterymanager";
    public static final String BIOMETRIC_SERVICE                = "biometric";
    public static final String BLUETOOTH_SERVICE                = "bluetooth";
    public static final String CAMERA_SERVICE                   = "camera";
    public static final String CAPTIONING_SERVICE               = "captioning";
    public static final String CARRIER_CONFIG_SERVICE           = "carrier_config";
    public static final String CLIPBOARD_SERVICE                = "clipboard";
    public static final String COMPANION_DEVICE_SERVICE         = "companiondevice";
    public static final String CONNECTIVITY_SERVICE             = "connectivity";
    public static final String CONSUMER_IR_SERVICE              = "consumer_ir";
    public static final String CROSS_PROFILE_APPS_SERVICE       = "crossprofileapps";
    public static final String DEVICE_POLICY_SERVICE            = "device_policy";
    public static final String DISPLAY_SERVICE                  = "display";
    public static final String DOWNLOAD_SERVICE                 = "download";
    public static final String DROPBOX_SERVICE                  = "dropbox";
    public static final String EUICC_SERVICE                    = "euicc";
    public static final String FINGERPRINT_SERVICE              = "fingerprint";
    public static final String HARDWARE_PROPERTIES_SERVICE      = "hardware_properties";
    public static final String INPUT_METHOD_SERVICE             = "input_method";
    public static final String INPUT_SERVICE                    = "input";
    public static final String IPSEC_SERVICE                    = "ipsec";
    public static final String JOB_SCHEDULER_SERVICE            = "jobscheduler";
    public static final String KEYGUARD_SERVICE                 = "keyguard";
    public static final String LAUNCHER_APPS_SERVICE            = "launcherapps";
    public static final String LAYOUT_INFLATER_SERVICE          = "layout_inflater";
    public static final String LOCATION_SERVICE                 = "location";
    public static final String MEDIA_PROJECTION_SERVICE         = "media_projection";
    public static final String MEDIA_ROUTER_SERVICE             = "media_router";
    public static final String MEDIA_SESSION_SERVICE            = "media_session";
    public static final String MIDI_SERVICE                     = "midi";
    public static final String NETWORK_STATS_SERVICE            = "netstats";
    public static final String NFC_SERVICE                      = "nfc";
    public static final String NOTIFICATION_SERVICE             = "notification";
    public static final String NSD_SERVICE                      = "servicediscovery";
    public static final String POWER_SERVICE                    = "power";
    public static final String PRINT_SERVICE                    = "print";
    public static final String RESTRICTIONS_SERVICE             = "restrictions";
    public static final String ROLE_SERVICE                     = "role";
    public static final String SEARCH_SERVICE                   = "search";
    public static final String SENSOR_SERVICE                   = "sensor";
    public static final String SHORTCUT_SERVICE                 = "shortcut";
    public static final String STORAGE_SERVICE                  = "storage";
    public static final String STORAGE_STATS_SERVICE            = "storagestats";
    public static final String SYSTEM_HEALTH_SERVICE            = "systemhealth";
    public static final String TELECOM_SERVICE                  = "telecom";
    public static final String TELEPHONY_SERVICE                = "phone";
    public static final String TELEPHONY_SUBSCRIPTION_SERVICE   = "telephony_subscription_service";
    public static final String TEXT_CLASSIFICATION_SERVICE      = "textclassification";
    public static final String TEXT_SERVICES_MANAGER_SERVICE    = "textservices";
    public static final String TV_INPUT_SERVICE                 = "tv_input";
    public static final String UI_MODE_SERVICE                  = "uimode";
    public static final String USAGE_STATS_SERVICE              = "usagestats";
    public static final String USB_SERVICE                      = "usb";
    public static final String USER_SERVICE                     = "user";
    public static final String VIBRATOR_SERVICE                 = "vibrator";
    public static final String WALLPAPER_SERVICE                = "wallpaper";
    public static final String WIFI_AWARE_SERVICE               = "wifiaware";
    public static final String WIFI_P2P_SERVICE                 = "wifip2p";
    public static final String WIFI_RTT_RANGING_SERVICE         = "wifirtt";
    public static final String WIFI_SERVICE                     = "wifi";
    public static final String WINDOW_SERVICE                   = "window";

    public static final int BIND_ABOVE_CLIENT           = 0x00000008;
    public static final int BIND_ADJUST_WITH_ACTIVITY   = 0x00000080;
    public static final int BIND_ALLOW_OOM_MANAGEMENT   = 0x00000010;
    public static final int BIND_AUTO_CREATE            = 0x00000001;
    public static final int BIND_DEBUG_UNBIND           = 0x00000002;
    public static final int BIND_EXTERNAL_SERVICE       = 0x80000000;
    public static final int BIND_IMPORTANT              = 0x00000040;
    public static final int BIND_NOT_FOREGROUND         = 0x00000004;
    public static final int BIND_WAIVE_PRIORITY         = 0x00000020;

    public static final int CONTEXT_IGNORE_SECURITY = 0x00000002;
    public static final int CONTEXT_INCLUDE_CODE    = 0x00000001;
    public static final int CONTEXT_RESTRICTED      = 0x00000004;

    public static final int MODE_APPEND                     = 0x00008000;
    public static final int MODE_ENABLE_WRITE_AHEAD_LOGGING = 0x00000008;
    public static final int MODE_MULTI_PROCESS              = 0x00000004;
    public static final int MODE_NO_LOCALIZED_COLLATORS     = 0x00000010;
    public static final int MODE_PRIVATE                    = 0x00000000;
    public static final int MODE_WORLD_READABLE             = 0x00000001;
    public static final int MODE_WORLD_WRITEABLE            = 0x00000002;

    public static final int RECEIVER_VISIBLE_TO_INSTANT_APPS = 0x00000001;

    public abstract boolean bindService(Intent service, ServiceConnection conn, int flags);

    public abstract int checkCallingOrSelfPermission(String permission);

    public abstract int checkCallingOrSelfPermission(Uri uri, int modeFlags);

    public abstract int checkCallingPermission(String permission);

    public abstract int checkCallingUriPermission(Uri uri, int modeFlags);

    public abstract int checkPermission(String permission, int pid, int uid);

    public abstract int checkSelfPermission(String permission);

    public abstract int checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid,
                                           int modeFlags);

    public abstract int checkUriPermission(Uri uri, int pid, int uid, int modeFlags);

    public abstract void clearWallpaper();

    public abstract Context createConfigurationContext(Configuration overrideConfiguration);

    public abstract Context createContextForSplit(String splitName);

    public abstract Context createDeviceProtectedStorageContext();

    public abstract Context createDisplayContext(Display display);

    public abstract Context createPackageContext(String packageName, int flags);

    public abstract String[] databaseList();

    public abstract boolean deleteDatabase(String name);

    public abstract boolean deleteFile(String name);

    public abstract boolean deleteSharedPreferences(String name);

    public abstract void enforceCallingOrSelfPermission(String permission, String message);

    public abstract void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message);

    public abstract void enforceCallingPermission(String permission, String message);

    public abstract void enforceCallingUriPermission(Uri uri, int modeFlags, String message);

    public abstract void enforcePermission(String permission, int pid, int uid, String message);

    public abstract void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid,
                                              int modeFlags, String message);

    public abstract void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message);

    public abstract String[] fileList();

    public abstract Context getApplicationContext();

    public abstract ApplicationInfo getApplicationInfo();

    public abstract AssetManager getAssets();

    public abstract File getCacheDir();

    public abstract ClassLoader getClassLoader();

    public abstract File getCodeCacheDir();

    public abstract ContentResolver getContentResolver();

    public abstract File getDataDir();

    public abstract File getDatabasePath(String name);

    public abstract File getDir(String name, int mode);

    public abstract File getExternalCacheDir();

    public abstract File[] getExternalCacheDirs();

    public abstract File getExternalFilesDir(String type);

    public abstract File[] getExternalFilesDirs(String type);

    public abstract File[] getExternalMediaDirs();

    public abstract File getFileStreamPath(String name);

    public abstract File getFilesDir();

    public abstract Looper getMainLooper();

    public abstract File getNoBackupFilesDir();

    public abstract File getObbDir();

    public abstract File[] getObbDirs();

    public abstract String getOpPackageName();

    public abstract String getPackageCodePath();

    public abstract PackageManager getPackageManager();

    public abstract String getPackageName();

    public abstract String getPackageResourcePath();

    public abstract Resources getResources();

    public abstract SharedPreferences getSharedPreferences(String name, int mode);

    public abstract Object getSystemService(String name);

    public abstract String getSystemServiceName(Class<?> serviceClass);

    public abstract Resources.Theme getTheme();

    public abstract Drawable getWallpaper();

    public abstract int getWallpaperDesiredMinimumHeight();

    public abstract int getWallpaperDesiredMinimumWidth();

    public abstract void grantUriPermission(String toPackage, Uri uri, int modeFlags);

    public abstract boolean isDeviceProtectedStorage();

    public abstract boolean moveDatabaseFrom(Context sourceContext, String name);

    public abstract boolean moveSharedPreferencesFrom(Context sourceContext, String name);

    public abstract FileInputStream openFileInput(String name);

    public abstract FileOutputStream openFileOutput(String name, int mode);

    public abstract SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory,
                                                        DatabaseErrorHandler errorHandler);

    public abstract SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory);

    public abstract Drawable peekWallpaper();

    public abstract Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter);

    public abstract Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, int flags);

    public abstract Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission,
                                            Handler scheduler, int flags);

    public abstract Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission,
                                            Handler scheduler);

    public abstract void removeStickyBroadcast(Intent intent);

    public abstract void removeStickyBroadcastAsUser(Intent intent, UserHandle user);

    public abstract void revokeUriPermission(Uri uri, int modeFlags);

    public abstract void revokeUriPermission(String toPackage, Uri uri, int modeFlags);

    public abstract void sendBroadcast(Intent intent, String receiverPermission);

    public abstract void sendBroadcast(Intent intent);

    public abstract void sendBroadcastAsUser(Intent intent, UserHandle user);

    public abstract void sendBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission);

    public abstract void sendOrderedBroadcast(Intent intent, String receiverPermission,
                                              BroadcastReceiver resultReceiver, Handler scheduler, int initialCode,
                                              String initialData, Bundle initialExtras);

    public abstract void sendOrderedBroadcast(Intent intent, String receiverPermission);

    public abstract void sendOrderedBroadcast(Intent intent, UserHandle user, String receiverPermission,
                                              BroadcastReceiver resultReceiver, Handler scheduler, int initialCode,
                                              String initialData, Bundle initialExtras);

    public abstract void sendStickyBroadcast(Intent intent);

    public abstract void sendStickyBroadcastAsUser(Intent intent, UserHandle user);

    public abstract void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver resultReceiver, Handler scheduler,
                                                    int initialCode, String initialData, Bundle initialExtras);

    public abstract void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle user,
                                                          BroadcastReceiver resultReceiver, Handler scheduler,
                                                          int initialCode, String initialData, Bundle initialExtras);

    public abstract void setTheme(int resid);

    public abstract void setWallpaper(Bitmap bitmap);

    public abstract void setWallpaper(InputStream data);

    public abstract void startActivities(Intent[] intents, Bundle options);

    public abstract void startActivities(Intent[] intents);

    public abstract void startActivity(Intent intent);

    public abstract void startActivity(Intent intent, Bundle options);

    public abstract ComponentName startForegroundService(Intent service);

    public abstract boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments);

    public abstract void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues,
                                           int extraFlags);

    public abstract void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues,
                                           int extraFlags, Bundle options);

    public abstract ComponentName startService(Intent service);

    public abstract boolean stopService(Intent service);

    public abstract void unbindService(ServiceConnection conn);

    public abstract void unregisterReceiver(BroadcastReceiver receiver);

    public final int getColor(int id) {
        log.warning("Unimplemented method: android.content.Context.getColor(int)");
        return 0;
    }

    public final ColorStateList getColorStateList(int id) {
        log.warning("Unimplemented method: android.content.Context.getColorStateList(int)");
        return null;
    }

    public Executor getMainExecutor() {
        log.warning("Unimplemented method: android.content.Context.getMainExecutor()");
        return null;
    }

    public final Drawable getDrawable(int id) {
        log.warning("Unimplemented method: android.content.Context.getDrawable(int)");
        return null;
    }

    public final String getString(int resId, Object... formatArgs) {
        log.warning("Unimplemented method: android.content.Context.getString(int, Object[])");
        return null;
    }

    public final String getString(int resId) {
        log.warning("Unimplemented method: android.content.Context.getString(int)");
        return null;
    }

    public final <T> T getSystemService(Class<T> serviceClass) {
        log.warning("Unimplemented method: android.content.Context.getSystemService(Class<T>)");
        return null;
    }

    public final CharSequence getText(int resId) {
        log.warning("Unimplemented method: android.content.Context.getText(int)");
        return null;
    }

    public boolean isRestricted() {
        log.warning("Unimplemented method: android.content.Context.isRestricted()");
        return false;
    }

    public final TypedArray obtainStyledAttributes(AttributeSet set, int[] attrs) {
        log.warning("Unimplemented method: android.content.Context.obtainStyledAttributes(android.util.AttributeSet, " +
                "int[])");

        return null;
    }

    public final TypedArray obtainStyledAttributes(AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes) {
        log.warning("Unimplemented method: android.content.Context.obtainStyledAttributes(android.util.AttributeSet, " +
                "int[], int, int)");

        return null;
    }

    public final TypedArray obtainStyledAttributes(int resid, int[] atts) {
        log.warning("Unimplemented method: android.content.Context.obtainStyledAttributes(int, int[])");
        return null;
    }

    public final TypedArray obtainStyledAttributes(int[] attrs) {
        log.warning("Unimplemented method: android.content.Context.obtainStyledAttributes(int[])");
        return null;
    }

    public void registerComponentCallbacks(ComponentCallbacks callback) {
        log.warning("Unimplemented method: android.content.Context.registerComponentCallbacks(" +
                "android.content.ComponentCallbacks)");
    }

    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        log.warning("Unimplemented method: android.content.Context.unregisterComponentCallbacks(" +
                "android.content.ComponentCallbacks)");
    }

    public void updateServiceGroup(ServiceConnection conn, int group, int importance) {
        log.warning("Unimplemented method: android.content.Context.updateServiceGroup(" +
                "android.content.ServiceConnection, int, int)");
    }
}
