package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import lombok.extern.java.Log;

@Log
public class Uri implements Parcelable, Comparable<Uri> {
    @Override
    public int compareTo(Uri uri) {
        log.warning("Unimplemented method: android.net.Uri.compareTo(android.net.Uri)");
        return 0;
    }

    @Override
    public int describeContents() {
        log.warning("android.net.Uri.describeContents()");
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        log.warning("android.net.Uri.writeToParcel(android.os.Parcel, int)");
    }
}
