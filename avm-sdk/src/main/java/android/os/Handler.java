package android.os;

import android.util.Printer;
import lombok.extern.java.Log;

@Log
public class Handler {
    public interface Callback {
        void handleMessage(Message msg);
    }
    
    public static Handler createAsync(Looper looper, Callback callback) {
        log.warning("Unimplemented method: android.os.Handler.createAsync");
        return null;
    }
    
    public static Handler createAsync(Looper looper) {
        log.warning("Unimplemented method: android.os.Handler.createAsync");
        return null;
    }
    
    public Handler() {
        log.warning("Unimplemented method: android.os.Handler.Handler");
    }
    
    public Handler(Callback callback) {
        log.warning("Unimplemented method: android.os.Handler.Handler");
    }
    
    public Handler(Looper looper) {
        log.warning("Unimplemented method: android.os.Handler.Handler");
    }
    
    public Handler(Looper looper, Callback callback) {
        log.warning("Unimplemented method: android.os.Handler.Handler");
    }
    
    public void dispatchMessage(Message msg) {
        log.warning("Unimplemented method: android.os.Handler.dispatchMessage");
    }
    
    public final void dump(Printer pw, String prefix) {
        log.warning("Unimplemented method: android.os.Handler.dump");
    }
    
    public final Looper getLooper() {
        log.warning("Unimplemented method: android.os.Handler.getLooper");
        return null;
    }
    
    public String getMessageName(Message message) {
        log.warning("Unimplemented method: android.os.Handler.getMessageName");
        return null;
    }
    
    public void handleMessage(Message msg) {
        log.warning("Unimplemented method: android.os.Handler.handleMessage");
    }
    
    public final boolean hasCallbacks(Runnable r) {
        log.warning("Unimplemented method: android.os.Handler.hasCallbacks");
        return false;
    }
    
    public final boolean hasMessages(int what) {
        log.warning("Unimplemented method: android.os.Handler.hasMessages");
        return false;
    }
    
    public final boolean hasMessages(int what, Object object) {
        log.warning("Unimplemented method: android.os.Handler.hasMessages");
        return false;
    }
    
    public final Message obtain(int what, Object obj) {
        log.warning("Unimplemented method: android.os.Handler.obtainMessage");
        return null;
    }
    
    public final Message obtainMessage() {
        log.warning("Unimplemented method: android.os.Handler.obtainMessage");
        return null;
    }
    
    public final Message obtainMessage(int what, int arg1, int arg2) {
        log.warning("Unimplemented method: android.os.Handler.obtainMessage");
        return null;
    }
    
    public final Message obtainMessage(int what, int arg1, int arg2, Object obj) {
        log.warning("Unimplemented method: android.os.Handler.obtainMessage");
        return null;
    }
    
    public final Message obtainMessage(int what) {
        log.warning("Unimplemented method: android.os.Handler.obtainMessage");
        return null;
    }
    
    public final boolean post(Runnable r) {
        log.warning("Unimplemented method: android.os.Handler.post");
        return false;
    }
    
    public final boolean postAtFrontOfQueue(Runnable r) {
        log.warning("Unimplemented method: android.os.Handler.postAtFrontOfQueue");
        return false;
    }
    
    public final boolean postAtTime(Runnable r, long uptimeMillis) {
        log.warning("Unimplemented method: android.os.Handler.postAtTime");
        return false;
    }
    
    public final boolean postAtTime(Runnable r, Object token, long uptimeMillis) {
        log.warning("Unimplemented method: android.os.Handler.postAtTime");
        return false;
    }
    
    public final boolean postDelayed(Runnable r, long delayMillis) {
        log.warning("Unimplemented method: android.os.Handler.postDelayed");
        return false;
    }
    
    public final boolean postDelayed(Runnable r, Object token, long delayMillis) {
        log.warning("Unimplemented method: android.os.Handler.postDelayed");
        return false;
    }
    
    public final void removeCallbacks(Runnable r) {
        log.warning("Unimplemented method: android.os.Handler.removeCallbacks");
    }
    
    public final void removeCallbacks(Runnable r, Object token) {
        log.warning("Unimplemented method: android.os.Handler.removeCallbacks");
    }
    
    public final void removeCallbacksAndMessages(Object token) {
        log.warning("Unimplemented method: android.os.Handler.removeCallbacksAndMessages");
    }
    
    public final void removeMessages(int what) {
        log.warning("Unimplemented method: android.os.Handler.removeMessages");
    }
    
    public final void removeMessages(int what, Object object) {
        log.warning("Unimplemented method: android.os.Handler.removeMessages");
    }
    
    public final boolean sendEmptyMessage(int what) {
        log.warning("Unimplemented method: android.os.Handler.sendEmptyMessage");
        return false;
    }
    
    public final boolean sendEmptyMessageAtTime(int what, long uptimeMillis) {
        log.warning("Unimplemented method: android.os.Handler.sendEmptyMessageAtTime");
        return false;
    }
    
    public final boolean sendEmptyMessageDelayed(int what, long delayMillis) {
        log.warning("Unimplemented method: android.os.Handler.sendEmptyMessageDelayed");
        return false;
    }
    
    public final boolean sendMessage(Message msg) {
        log.warning("Unimplemented method: android.os.Handler.sendMessage");
        return false;
    }
    
    public final boolean sendMessageAtFrontOfQueue(Message msg) {
        log.warning("Unimplemented method: android.os.Handler.sendMessageAtFrontOfQueue");
        return false;
    }
    
    public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
        log.warning("Unimplemented method: android.os.Handler.sendMessageAtTime");
        return false;
    }
    
    public final boolean sendMessageDelayed(Message msg, long delayMillis) {
        log.warning("Unimplemented method: android.os.Handler.sendMessageDelayed");
        return false;
    }
}
