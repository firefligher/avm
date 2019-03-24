package android.content;

import android.os.Parcel;
import android.os.Parcelable;
import lombok.extern.java.Log;

@Log
public class ClipData implements Parcelable {
    @Override
    public int describeContents() {
        log.warning("Unimplemented method: android.content.ClipData.describeContents()");
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        log.warning("Unimplemented method: android.content.ClipData.writeToParcel(android.os.Parcel, int)");
    }
}
