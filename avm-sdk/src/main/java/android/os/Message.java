package android.os;

import lombok.extern.java.Log;

@Log
public final class Message implements Parcelable {
    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel source) {
            log.warning("android.os.Message.CREATOR.createFromParcel(android.os.Parcel)");
            return null;
        }

        @Override
        public Message[] newArray(int size) {
            log.warning("android.os.Message.CREATOR.newArray(int)");
            return null;
        }
    };
    
    public static Message obtain(Handler h) {
        log.warning("Unimplemented method: android.os.Message.obtain(android.os.Handler)");
        return null;
    }
    
    public static Message obtain(Handler h, int what) {
        log.warning("Unimplemented method: android.os.Message.obtain(android.os.Handler, int)");
        return null;
    }
    
    public static Message obtain(Handler h, Runnable callback) {
        log.warning("Unimplemented method: android.os.Message.obtain(android.os.Handler, java.lang.Runnable)");
        return null;
    }
    
    public static Message obtain(Message orig) {
        log.warning("Unimplemented method: android.os.Message.obtain(android.os.Message)");
        return null;
    }
    
    public static Message obtain(Handler h, int what, int arg1, int arg2, Object obj) {
        log.warning("Unimplemented method: android.os.Message.obtain(android.os.Handler, int, int, int, Object)");
        return null;
    }
    
    public static Message obtain(Handler h, int what, int arg1, int arg2) {
        log.warning("Unimplemented method: android.os.Message.obtain(android.os.Handler, int, int, int)");
        return null;
    }
    
    public static Message obtain(Handler h, int what, Object obj) {
        log.warning("Unimplemented method: android.os.Message.obtain(android.os.Handler, int, Object)");
        return null;
    }
    
    public static Message obtain() {
        log.warning("Unimplemented method: android.os.Message.obtain()");
        return null;
    }
    
    public int arg1;
    public int arg2;
    public Object obj;
    public Messenger replyTo;
    public int sendingUid;
    public int what;
    
    public void copyFrom(Message o) {
        log.warning("Unimplemented method: android.os.Message.copyFrom(android.os.Message)");
    }
    
    @Override
    public int describeContents() {
        log.warning("android.os.Message.describeContents()");
        return 0;
    }
    
    public Runnable getCallback() {
        log.warning("Unimplemented method: android.os.Message.getCallback()");
        return null;
    }
    
    public Bundle getData() {
        log.warning("Unimplemented method: android.os.Message.getData()");
        return null;
    }
    
    public Handler getTarget() {
        log.warning("Unimplemented method: android.os.Message.getTarget()");
        return null;
    }
    
    public long getWhen() {
        log.warning("Unimplemented method: android.os.Message.getWhen()");
        return 0L;
    }
    
    public boolean isAsynchronous() {
        log.warning("Unimplemented method: android.os.Message.isAsynchronous()");
        return false;
    }
    
    public Bundle peekData() {
        log.warning("Unimplemented method: android.os.Message.peekData()");
        return null;
    }
    
    public void recycle() {
        log.warning("Unimplemented method: android.os.Message.recycle()");
    }
    
    public void sendToTarget() {
        log.warning("Unimplemented method: android.os.Message.sendToTarget()");
    }
    
    public void setAsynchronous(boolean async) {
        log.warning("Unimplemented method: android.os.Message.setAsynchronous(boolean)");
    }
    
    public void setData(Bundle data) {
        log.warning("Unimplemented method: android.os.Message.setData(android.os.Bundle)");
    }
    
    public void setTarget(Handler target) {
        log.warning("Unimplemented method: android.os.Message.setTarget(android.os.Handler)");
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        log.warning("android.os.Message.writeToParcel(android.os.Parcel, int)");
    }
}
