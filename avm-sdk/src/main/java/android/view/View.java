package android.view;

import android.drawable.Drawable;
import android.view.accessibility.AccessibilityEventSource;
import lombok.extern.java.Log;

@Log
public class View implements Drawable.Callback, KeyEvent.Callback, AccessibilityEventSource {
    public interface OnClickListener {
        void onClick(View view);
    }

    public interface OnCreateContextMenuListener {

    }

    public interface OnTouchListener {

    }

    public interface OnLongClickListener {
        boolean onLongClick(View v);
    }

    public interface OnKeyListener {
        boolean onKey(View v, int keyCode, KeyEvent event);
    }

    @Override
    public void invalidateDrawable(Drawable who) {
        log.warning("Unimplemented method: android.view.View.invalidateDrawable(android.drawable.Drawable)");
    }

    @Override
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        log.warning("Unimplemented method: android.view.View.scheduleDrawable(android.drawable.Drawable, " +
                "java.lang.Runnable, long)");
    }

    @Override
    public void unscheduleDrawable(Drawable who, Runnable what) {
        log.warning("Unimplemented method: android.view.View.unscheduleDrawable(android.drawable.Drawable, " +
                "java.lang.Runnable)");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        log.warning("Unimplemented method: android.view.View.onKeyDown(int, android.view.KeyEvent)");
        return false;
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        log.warning("Unimplemented method: android.view.View.onKeyLongPress(int, android.view.KeyEvent)");
        return false;
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int count, KeyEvent event) {
        log.warning("Unimplemented method: android.view.View.onKeyMultiple(int, int, android.view.KeyEvent)");
        return false;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        log.warning("Unimplemented method: android.view.View.onKeyUp(int, android.view.KeyEvent)");
        return false;
    }
}
