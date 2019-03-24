package android.content;

import android.os.Parcel;
import android.os.Parcelable;
import lombok.extern.java.Log;

@Log
public final class ComponentName implements Parcelable, Cloneable, Comparable<ComponentName> {
    @Override
    public int compareTo(ComponentName componentName) {
        log.warning("Unimplemented method: android.content.ComponentName.compareTo(android.content.ComponentName)");
        return 0;
    }

    @Override
    public int describeContents() {
        log.warning("android.content.ComponentName.describeContents()");
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        log.warning("android.content.ComponentName.writeToParcel(android.os.Parcel, int)");
    }
}
