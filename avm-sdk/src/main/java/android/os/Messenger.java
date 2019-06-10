package android.os;

import lombok.extern.java.Log;

@Log
public final class Messenger implements Parcelable {
    public static final Creator<Messenger> CREATOR = new Creator<Messenger>() {
        @Override
        public Messenger createFromParcel(Parcel source) {
            log.warning("android.os.Messenger.CREATOR.createFromParcel(android.os.Parcel)");
            return null;
        }

        @Override
        public Messenger[] newArray(int size) {
            log.warning("android.os.Messenger.CREATOR.newArray(int)");
            return null;
        }
    };
    
    public static Messenger readMessengerOrNullFromParcel(Parcel in) {
        log.warning("Unimplemented method: android.os.Messenger.readMessengerOrNullFromParcel(android.os.Parcel)");
        return null;
    }
    
    public static void writeMessengerOrNullToParcel(Messenger messenger, Parcel out) {
        log.warning("Unimplemented method: android.os.Messenger.writeMessengerOrNullToParcel(android.os.Messenger, "
                + "android.os.Parcel)");
    }
    
    public Messenger(Handler target) {
        log.warning("Unimplemented method: android.os.Messenger.Messenger(android.os.Handler)");
    }
    
    public Messenger(IBinder target) {
        log.warning("Unimplemented method: android.os.Messenger.Messenger(android.os.IBinder)");
    }

    @Override
    public int describeContents() {
        log.warning("Unimplemented method: android.os.Messenger.describeContents()");
        return 0;
    }
    
    public IBinder getBinder() {
        log.warning("Unimplemented method: android.os.Messenger.getBinder()");
        return null;
    }
    
    public void send(Message message) {
        log.warning("Unimplemented method: android.os.Messenger.send(android.os.Message)");
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        log.warning("Unimplemented method: android.os.Messenger.writeToParcel(android.os.Parcel, int)");
    }
}
