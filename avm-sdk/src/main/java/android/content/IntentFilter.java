package android.content;

import android.os.Parcel;
import android.os.Parcelable;
import lombok.extern.java.Log;

@Log
public class IntentFilter implements Parcelable {
    @Override
    public int describeContents() {
        log.warning("android.content.IntentFilter.describeContents()");
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        log.warning("android.content.IntentFilter.writeToParcel(android.os.Parcel, int)");
    }
}
