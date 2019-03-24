package android.view;

import android.os.Parcel;
import android.os.Parcelable;
import lombok.extern.java.Log;

@Log
public class KeyEvent extends InputEvent implements Parcelable {
    public interface Callback {
        boolean onKeyDown(int keyCode, KeyEvent event);

        boolean onKeyLongPress(int keyCode, KeyEvent event);

        boolean onKeyMultiple(int keyCode, int count, KeyEvent event);

        boolean onKeyUp(int keyCode, KeyEvent event);
    }

    @Override
    public int describeContents() {
        log.warning("android.view.KeyEvent.describeContents()");
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        log.warning("android.view.KeyEvent.writeToParcel(android.os.Parcel, int)");
    }
}
