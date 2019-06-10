package android.os;

import lombok.extern.java.Log;

@Log
public class HandlerThread extends Thread {
    public HandlerThread(String name) {
        log.warning("Unimplemented method: android.os.HandlerThread.HandlerThread(java.lang.String)");
    }
    
    public HandlerThread(String name, int priority) {
        log.warning("Unimplemented method: android.os.HandlerThread.HandlerThread(java.lang.String, int)");
    }
    
    public Looper getLooper() {
        log.warning("Unimplemented method: android.os.HandlerThread.getLooper()");
        return null;
    }
    
    public int getThreadId() {
        log.warning("Unimplemented method: android.os.HandlerThread.getThreadId()");
        return 0;
    }
    
    public boolean quit() {
        log.warning("Unimplemented method: android.os.HandlerThread.quit()");
        return false;
    }
    
    public boolean quitSafely() {
        log.warning("Unimplemented method: android.os.HandlerThread.quitSafely()");
        return false;
    }
    
    protected void onLooperPrepared() {
        log.warning("Unimplemented method: android.os.HandlerThread.onLooperPrepared()");
    }
}
