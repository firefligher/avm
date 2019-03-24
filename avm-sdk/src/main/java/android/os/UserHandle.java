package android.os;

import lombok.extern.java.Log;

@Log
public final class UserHandle implements Parcelable {
    @Override
    public int describeContents() {
        log.warning("android.os.UserHandle.describeContents()");
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        log.warning("android.os.UserHandle.writeToParcel(android.os.Parcel, int)");
    }
}
