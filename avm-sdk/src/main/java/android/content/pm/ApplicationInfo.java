package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import lombok.extern.java.Log;

@Log
public class ApplicationInfo extends PackageItemInfo implements Parcelable {
    @Override
    public int describeContents() {
        log.warning("android.content.pm.ApplicationInfo.describeContents()");
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        log.warning("android.content.pm.ApplicationInfo.writeToParcel(android.os.Parcel, int)");
    }
}
