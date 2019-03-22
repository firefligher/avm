package android.content;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.drawable.Drawable;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.*;
import android.view.Display;
import lombok.extern.java.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

@Log
public class ContextWrapper extends Context {
    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        log.warning("Unimplemented method: android.content.ContextWrapper.bindService(android.content.Intent, " +
                "android.content.ServiceConnection, int)");
        return false;
    }

    @Override
    public int checkCallingOrSelfPermission(String permission) {
        log.warning("Unimplemented method: android.content.ContextWrapper.checkCallingOrSelfPermission(" +
                "java.lang.String)");
        return 0;
    }

    @Override
    public int checkCallingOrSelfPermission(Uri uri, int modeFlags) {
        log.warning("Unimplemented method: android.content.ContextWrapper.checkCallingOrSelfPermission");
        return 0;
    }

    @Override
    public int checkCallingPermission(String permission) {
        log.warning("Unimplemented method: android.content.ContextWrapper.checkCallingOrSelfPermission");
        return 0;
    }

    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        log.warning("Unimplemented method: android.content.ContextWrapper.checkCallingUriPermission");
        return 0;
    }

    @Override
    public int checkPermission(String permission, int pid, int uid) {
        log.warning("Unimplemented method: android.content.ContextWrapper.checkPermission");
        return 0;
    }

    @Override
    public int checkSelfPermission(String permission) {
        log.warning("Unimplemented method: android.content.ContextWrapper.checkSelfPermission");
        return 0;
    }

    @Override
    public int checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid,
                                  int modeFlags) {
        log.warning("Unimplemented method: android.content.ContextWrapper.checkUriPermission");
        return 0;
    }

    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        log.warning("Unimplemented method: android.content.ContextWrapper.checkUriPermission");
        return 0;
    }

    @Override
    public void clearWallpaper() {
        log.warning("Unimplemented method: android.content.ContextWrapper.clearWallpaper");
    }

    @Override
    public Context createConfigurationContext(Configuration overrideConfiguration) {
        log.warning("Unimplemented method: android.content.ContextWrapper.createConfigurationContext");
        return null;
    }

    @Override
    public Context createContextForSplit(String splitName) {
        log.warning("Unimplemented method: android.content.ContextWrapper.createContextForSplit");
        return null;
    }

    @Override
    public Context createDeviceProtectedStorageContext() {
        log.warning("Unimplemented method: android.content.ContextWrapper.createDeviceProtectedStorageContext");
        return null;
    }

    @Override
    public Context createDisplayContext(Display display) {
        log.warning("Unimplemented method: android.content.ContextWrapper.createDisplayContext");
        return null;
    }

    @Override
    public Context createPackageContext(String packageName, int flags) {
        log.warning("Unimplemented method: android.content.ContextWrapper.createPackageContext");
        return null;
    }

    @Override
    public String[] databaseList() {
        log.warning("Unimplemented method: android.content.ContextWrapper.databaseList");
        return new String[0];
    }

    @Override
    public boolean deleteDatabase(String name) {
        log.warning("Unimplemented method: android.content.ContextWrapper.deleteDatabase");
        return false;
    }

    @Override
    public boolean deleteFile(String name) {
        log.warning("Unimplemented method: android.content.ContextWrapper.deleteFile");
        return false;
    }

    @Override
    public boolean deleteSharedPreferences(String name) {
        log.warning("Unimplemented method: android.content.ContextWrapper.deleteSharedPreferences");
        return false;
    }

    @Override
    public void enforceCallingOrSelfPermission(String permission, String message) {
        log.warning("Unimplemented method: android.content.ContextWrapper.enforceCallingOrSelfPermission");
    }

    @Override
    public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
        log.warning("Unimplemented method: android.content.ContextWrapper.enforceCallingOrSelfUriPermission");
    }

    @Override
    public void enforceCallingPermission(String permission, String message) {
        log.warning("Unimplemented method: android.content.ContextWrapper.enforceCallingPermission");
    }

    @Override
    public void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {
        log.warning("Unimplemented method: android.content.ContextWrapper.enforceCallingUriPermission");
    }

    @Override
    public void enforcePermission(String permission, int pid, int uid, String message) {
        log.warning("Unimplemented method: android.content.ContextWrapper.enforcePermission");
    }

    @Override
    public void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid,
                                     int modeFlags, String message) {
        log.warning("Unimplemented method: android.content.ContextWrapper.enforceUriPermission");
    }

    @Override
    public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {
        log.warning("Unimplemented method: android.content.ContextWrapper.enforceUriPermission");
    }

    @Override
    public String[] fileList() {
        log.warning("Unimplemented method: android.content.ContextWrapper.fileList");
        return new String[0];
    }

    @Override
    public Context getApplicationContext() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getApplicationContext");
        return null;
    }

    @Override
    public ApplicationInfo getApplicationInfo() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getApplicationInfo");
        return null;
    }

    @Override
    public AssetManager getAssets() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getAssets");
        return null;
    }

    @Override
    public File getCacheDir() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getCacheDir");
        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getClassLoader");
        return null;
    }

    @Override
    public File getCodeCacheDir() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getCodeCacheDir");
        return null;
    }

    @Override
    public ContentResolver getContentResolver() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getContentResolver");
        return null;
    }

    @Override
    public File getDataDir() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getDataDir");
        return null;
    }

    @Override
    public File getDatabasePath(String name) {
        log.warning("Unimplemented method: android.content.ContextWrapper.getDatabasePath");
        return null;
    }

    @Override
    public File getDir(String name, int mode) {
        log.warning("Unimplemented method: android.content.ContextWrapper.getDir");
        return null;
    }

    @Override
    public File getExternalCacheDir() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getExternalCacheDir");
        return null;
    }

    @Override
    public File[] getExternalCacheDirs() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getExternalCacheDirs");
        return new File[0];
    }

    @Override
    public File getExternalFilesDir(String type) {
        log.warning("Unimplemented method: android.content.ContextWrapper.getExternalFilesDir");
        return null;
    }

    @Override
    public File[] getExternalFilesDirs(String type) {
        log.warning("Unimplemented method: android.content.ContextWrapper.getExternalFilesDirs");
        return new File[0];
    }

    @Override
    public File[] getExternalMediaDirs() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getExternalMediaDirs");
        return new File[0];
    }

    @Override
    public File getFileStreamPath(String name) {
        log.warning("Unimplemented method: android.content.ContextWrapper.getFileStreamPath");
        return null;
    }

    @Override
    public File getFilesDir() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getFilesDir");
        return null;
    }

    @Override
    public Looper getMainLooper() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getMainLooper");
        return null;
    }

    @Override
    public File getNoBackupFilesDir() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getNoBackupFilesDir");
        return null;
    }

    @Override
    public File getObbDir() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getObbDir");
        return null;
    }

    @Override
    public File[] getObbDirs() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getObbDirs");
        return new File[0];
    }

    @Override
    public String getOpPackageName() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getOpPackageName");
        return null;
    }

    @Override
    public String getPackageCodePath() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getPackageCodePath");
        return null;
    }

    @Override
    public PackageManager getPackageManager() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getPackageManager");
        return null;
    }

    @Override
    public String getPackageName() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getPackageName");
        return null;
    }

    @Override
    public String getPackageResourcePath() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getPackageResourcePath");
        return null;
    }

    @Override
    public Resources getResources() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getResources");
        return null;
    }

    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        log.warning("Unimplemented method: android.content.ContextWrapper.getSharedPreferences");
        return null;
    }

    @Override
    public Object getSystemService(String name) {
        log.warning("Unimplemented method: android.content.ContextWrapper.getSystemService");
        return null;
    }

    @Override
    public String getSystemServiceName(Class<?> serviceClass) {
        log.warning("Unimplemented method: android.content.ContextWrapper.getSystemServiceName");
        return null;
    }

    @Override
    public Resources.Theme getTheme() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getTheme");
        return null;
    }

    @Override
    public Drawable getWallpaper() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getWallpaper");
        return null;
    }

    @Override
    public int getWallpaperDesiredMinimumHeight() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getWallpaperDesiredMinimumHeight");
        return 0;
    }

    @Override
    public int getWallpaperDesiredMinimumWidth() {
        log.warning("Unimplemented method: android.content.ContextWrapper.getWallpaperDesiredMinimumWidth");
        return 0;
    }

    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        log.warning("Unimplemented method: android.content.ContextWrapper.grantUriPermission");
    }

    @Override
    public boolean isDeviceProtectedStorage() {
        log.warning("Unimplemented method: android.content.ContextWrapper.isDeviceProtectedStorage");
        return false;
    }

    @Override
    public boolean moveDatabaseFrom(Context sourceContext, String name) {
        log.warning("Unimplemented method: android.content.ContextWrapper.moveDatabaseFrom");
        return false;
    }

    @Override
    public boolean moveSharedPreferencesFrom(Context sourceContext, String name) {
        log.warning("Unimplemented method: android.content.ContextWrapper.moveSharedPreferencesFrom");
        return false;
    }

    @Override
    public FileInputStream openFileInput(String name) {
        log.warning("Unimplemented method: android.content.ContextWrapper.openFileInput");
        return null;
    }

    @Override
    public FileOutputStream openFileOutput(String name, int mode) {
        log.warning("Unimplemented method: android.content.ContextWrapper.openFileOutput");
        return null;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory,
                                               DatabaseErrorHandler errorHandler) {
        log.warning("Unimplemented method: android.content.ContextWrapper.openOrCreateDatabase");
        return null;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        log.warning("Unimplemented method: android.content.ContextWrapper.openOrCreateDatabase");
        return null;
    }

    @Override
    public Drawable peekWallpaper() {
        log.warning("Unimplemented method: android.content.ContextWrapper.peekWallpaper");
        return null;
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        log.warning("Unimplemented method: android.content.ContextWrapper.registerReceiver");
        return null;
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, int flags) {
        log.warning("Unimplemented method: android.content.ContextWrapper.registerReceiver");
        return null;
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission,
                                   Handler scheduler, int flags) {
        log.warning("Unimplemented method: android.content.ContextWrapper.registerReceiver");
        return null;
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission,
                                   Handler scheduler) {
        log.warning("Unimplemented method: android.content.ContextWrapper.registerReceiver");
        return null;
    }

    @Override
    public void removeStickyBroadcast(Intent intent) {
        log.warning("Unimplemented method: android.content.ContextWrapper.removeStickyBroadcast");
    }

    @Override
    public void removeStickyBroadcastAsUser(Intent intent, UserHandle user) {
        log.warning("Unimplemented method: android.content.ContextWrapper.removeStickyBroadcastAsUser");
    }

    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        log.warning("Unimplemented method: android.content.ContextWrapper.revokeUriPermission");
    }

    @Override
    public void revokeUriPermission(String toPackage, Uri uri, int modeFlags) {
        log.warning("Unimplemented method: android.content.ContextWrapper.revokeUriPermission");
    }

    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        log.warning("Unimplemented method: android.content.ContextWrapper.sendBroadcast");
    }

    @Override
    public void sendBroadcast(Intent intent) {
        log.warning("Unimplemented method: android.content.ContextWrapper.sendBroadcast");
    }

    @Override
    public void sendBroadcastAsUser(Intent intent, UserHandle user) {
        log.warning("Unimplemented method: android.content.ContextWrapper.sendBroadcastAsUser");
    }

    @Override
    public void sendBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission) {
        log.warning("Unimplemented method: android.content.ContextWrapper.sendBroadcastAsUser");
    }

    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver,
                                     Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        log.warning("Unimplemented method: android.content.ContextWrapper.sendOrderedBroadcast");
    }

    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission) {
        log.warning("Unimplemented method: android.content.ContextWrapper.sendOrderedBroadcast");
    }

    @Override
    public void sendOrderedBroadcast(Intent intent, UserHandle user, String receiverPermission,
                                     BroadcastReceiver resultReceiver, Handler scheduler, int initialCode,
                                     String initialData, Bundle initialExtras) {
        log.warning("Unimplemented method: android.content.ContextWrapper.sendOrderedBroadcast");
    }

    @Override
    public void sendStickyBroadcast(Intent intent) {
        log.warning("Unimplemented method: android.content.ContextWrapper.sendStickyBroadcast");
    }

    @Override
    public void sendStickyBroadcastAsUser(Intent intent, UserHandle user) {
        log.warning("Unimplemented method: android.content.ContextWrapper.sendStickyBroadcastAsUser(" +
                "android.content.Intent, android.os.UserHandle)");
    }

    @Override
    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver resultReceiver, Handler scheduler,
                                           int initialCode, String initialData, Bundle initialExtras) {
        log.warning("Unimplemented method: android.content.ContextWrapper.sendStickyOrderedBroadcast(" +
                "android.content.Intent, android.content.BroadcastReceiver, android.os.Handler, int, " +
                "java.lang.String, android.os.Bundle)");
    }

    @Override
    public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle user, BroadcastReceiver resultReceiver,
                                                 Handler scheduler, int initialCode, String initialData,
                                                 Bundle initialExtras) {
        log.warning("Unimplemented method: android.content.ContextWrapper.sendStickyOrderedBroadcastAsUser(" +
                "android.content.Intent, android.os.UserHandle, android.content.BroadcastReceiver, " +
                "android.os.Handler, int, java.lang.String, android.os.Bundle)");
    }

    @Override
    public void setTheme(int resid) {
        log.warning("Unimplemented method: android.content.ContextWrapper.setTheme(int)");
    }

    @Override
    public void setWallpaper(Bitmap bitmap) {
        log.warning("Unimplemented method: android.content.ContextWrapper.setWallpaper(android.graphics.Bitmap)");
    }

    @Override
    public void setWallpaper(InputStream data) {
        log.warning("Unimplemented method: android.content.ContextWrapper.setWallpaper(java.io.InputStream)");
    }

    @Override
    public void startActivities(Intent[] intents, Bundle options) {
        log.warning("Unimplemented method: android.content.ContextWrapper.startActivities(android.content.Intent[], " +
                "android.os.Bundle[])");
    }

    @Override
    public void startActivities(Intent[] intents) {
        log.warning("Unimplemented method: android.content.ContextWrapper.startActivities(android.content.Intent[])");
    }

    @Override
    public void startActivity(Intent intent) {
        log.warning("Unimplemented method: android.content.ContextWrapper.startActivity(android.content.Intent)");
    }

    @Override
    public void startActivity(Intent intent, Bundle options) {
        log.warning("Unimplemented method: android.content.ContextWrapper.startActivity(android.content.Intent, " +
                "android.os.Bundle)");
    }

    @Override
    public ComponentName startForegroundService(Intent service) {
        log.warning("Unimplemented method: android.content.ContextWrapper.startForegroundService(" +
                "android.content.Intent)");
        return null;
    }

    @Override
    public boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments) {
        log.warning("Unimplemented method: android.content.ContextWrapper.startInstrumentation(" +
                "android.content.ComponentName, java.lang.String, android.os.Bundle)");
        return false;
    }

    @Override
    public void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues,
                                  int extraFlags) {
        log.warning("Unimplemented method: android.content.ContextWrapper.startIntentSender(android.os.IntentSender, " +
                "android.content.Intent, int, int, int)");
    }

    @Override
    public void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues,
                                  int extraFlags, Bundle options) {
        log.warning("Unimplemented method: android.content.ContextWrapper.startIntentSender(android.os.IntentSender, " +
                "android.content.Intent, int, int, int, android.os.Bundle)");
    }

    @Override
    public ComponentName startService(Intent service) {
        log.warning("Unimplemented method: android.content.ContextWrapper.startService(android.content.Intent)");
        return null;
    }

    @Override
    public boolean stopService(Intent service) {
        log.warning("Unimplemented method: android.content.ContextWrapper.stopService(android.content.Intent)");
        return false;
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        log.warning("Unimplemented method: android.content.ContextWrapper.unbindService(" +
                "android.content.ServiceConnection)");
    }

    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        log.warning("Unimplemented method: android.content.ContextWrapper.unregisterReceiver(" +
                "android.content.BroadcastReceiver)");
    }
}
