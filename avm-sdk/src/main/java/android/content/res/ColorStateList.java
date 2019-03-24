package android.content.res;

import android.os.Parcel;
import android.os.Parcelable;
import lombok.extern.java.Log;

@Log
public class ColorStateList implements Parcelable {
    @Override
    public int describeContents() {
        log.warning("android.content.res.ColorStateList.describeContents()");
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        log.warning("android.content.res.ColorStateList.writeToParcel(android.os.Parcel, int)");
    }
}
