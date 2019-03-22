package android.app;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import lombok.extern.java.Log;

@Log
public class Dialog implements DialogInterface, Window.Callback, KeyEvent.Callback, View.OnCreateContextMenuListener {
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        log.warning("Unimplemented method: android.app.Dialog.onKeyDown(int, android.view.KeyEvent)");
        return false;
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        log.warning("Unimplemented method: android.app.Dialog.onKeyLongPress(int, android.view.KeyEvent)");
        return false;
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int count, KeyEvent event) {
        log.warning("Unimplemented method: android.app.Dialog.onKeyMultiple(int, int, android.view.KeyEvent)");
        return false;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        log.warning("Unimplemented method: android.app.Dialog.onKeyUp(int, android.view.KeyEvent)");
        return false;
    }

    @Override
    public void cancel() {
        log.warning("Unimplemented method: android.app.Dialog.cancel()");
    }

    @Override
    public void dismiss() {

    }
}
