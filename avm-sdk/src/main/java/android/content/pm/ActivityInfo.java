package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import lombok.extern.java.Log;

@Log
public class ActivityInfo extends ComponentInfo implements Parcelable {
    @Override
    public int describeContents() {
        log.warning("Unimplemented method: android.content.pm.ActivityInfo.describeContents()");
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        log.warning("Unimplemented method: android.content.pm.ActivityInfo.writeToParcel(android.os.Parcel, int)");
    }
}
