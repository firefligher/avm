package android.os;

import lombok.extern.java.Log;

@Log
public final class Bundle extends BaseBundle implements Cloneable, Parcelable {
    @Override
    public int describeContents() {
        log.warning("android.os.Bundle.describeContents()");
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        log.warning("android.os.Bundle.writeToParcel(android.os.Parcel, int)");
    }
}
