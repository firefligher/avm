package android.graphics;

import android.os.Parcel;
import android.os.Parcelable;
import lombok.extern.java.Log;

@Log
public final class Bitmap implements Parcelable {
    @Override
    public int describeContents() {
        log.warning("android.graphics.Bitmap.describeContents()");
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        log.warning("android.graphics.Bitmap.writeToParcel(android.os.Parcel, int)");
    }
}
