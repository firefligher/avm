package android.os;

import android.util.Printer;
import lombok.extern.java.Log;

@Log
public final class Looper {
    public static Looper getMainLooper() {
        log.warning("Unimplemented method: android.os.Looper.getMainLooper()");
        return null;
    }
    
    public static void loop() {
        log.warning("Unimplemented method: android.os.Looper.loop()");
    }
    
    public static Looper myLooper() {
        log.warning("Unimplemented method: android.os.Looper.myLooper()");
        return null;
    }
    
    public static MessageQueue myQueue() {
        log.warning("Unimplemented method: android.os.Looper.myQueue()");
        return null;
    }
    
    public static void prepare() {
        log.warning("Unimplemented method: android.os.Looper.prepare()");
    }
    
    public static void prepareMainLooper() {
        log.warning("Unimplemented method: android.os.Looper.prepareMainLooper()");
    }
    
    public void dump(Printer pw, String prefix) {
        log.warning("Unimplemented method: android.os.Looper.dump(android.util.Printer, java.lang.String)");
    }
    
    public MessageQueue getQueue() {
        log.warning("Unimplemented method: android.os.Looper.getQueue()");
        return null;
    }
    
    public Thread getThread() {
        log.warning("Unimplemented method: android.os.Looper.getThread()");
        return null;
    }
    
    public boolean isCurrentThread() {
        log.warning("Unimplemented method: android.os.Looper.isCurrentThread()");
        return false;
    }
    
    public void quit() {
        log.warning("Unimplemented method: android.os.Looper.quit()");
    }
    
    public void quitSafely() {
        log.warning("Unimplemented method: android.os.Looper.quitSafely()");
    }
    
    public void setMessageLogging(Printer printer) {
        log.warning("Unimplemented method: android.os.Looper.setMessageLogging(android.util.Printer)");
    }
}
