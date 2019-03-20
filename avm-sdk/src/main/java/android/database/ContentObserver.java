package android.database;

import android.net.Uri;
import android.os.Handler;
import lombok.extern.java.Log;

@Log
public abstract class ContentObserver {
    public ContentObserver(Handler handler) {
        log.warning("Unimplemented method: android.database.ContentObserver.ContentObserver(android.os.Handler)");
    }

    public boolean deliverSelfNotifications() {
        log.warning("Unimplemented method: android.database.ContentObserver.deliverSelfNotifications()");
        return false;
    }

    public final void dispatchChange(boolean selfChange) {
        log.warning("Unimplemented method: android.database.ContentObserver.dispatchChange(boolean)");
    }

    public final void dispatchChange(boolean selfChange, Uri uri) {
        log.warning("Unimplemented method: android.database.ContentObserver.dispatchChange(boolean, android.net.Uri)");
    }

    public void onChange(boolean selfChange) {
        log.warning("Unimplemented method: android.database.ContentObserver.onChange(boolean)");
    }

    public void onChange(boolean selfChange, Uri uri) {
        log.warning("Unimplemented method: android.database.ContentObserver.onChange(boolean, android.net.Uri)");
    }
}
