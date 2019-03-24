package android.content.res;

import android.os.Parcel;
import android.os.Parcelable;
import lombok.extern.java.Log;

@Log
public final class Configuration implements Parcelable, Comparable<Configuration> {
    @Override
    public int compareTo(Configuration configuration) {
        log.warning("Unimplemented method: android.content.res.Configuration.compareTo(" +
                "android.content.res.Configuration)");

        return 0;
    }

    @Override
    public int describeContents() {
        log.warning("android.content.res.Configuration.describeContents()");
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        log.warning("android.content.res.Configuration.writeToParcel(android.os.Parcel, int)");
    }
}
