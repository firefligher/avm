package android.os;

import lombok.extern.java.Log;

@Log
public class IntentSender implements Parcelable {
    @Override
    public int describeContents() {
        log.warning("android.os.IntentSender.describeContents()");
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        log.warning("android.os.IntentSender.writeToParcel(android.os.Parcel, int)");
    }
}
