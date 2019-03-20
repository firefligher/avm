package android.view;

import android.os.Parcelable;

public class KeyEvent extends InputEvent implements Parcelable {
    public interface Callback {
        boolean onKeyDown(int keyCode, KeyEvent event);

        boolean onKeyLongPress(int keyCode, KeyEvent event);

        boolean onKeyMultiple(int keyCode, int count, KeyEvent event);

        boolean onKeyUp(int keyCode, KeyEvent event);
    }
}
