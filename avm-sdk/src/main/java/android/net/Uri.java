package android.net;

import android.os.Parcelable;
import lombok.extern.java.Log;

@Log
public class Uri implements Parcelable, Comparable<Uri> {
    @Override
    public int compareTo(Uri uri) {
        log.warning("Unimplemented method: android.net.Uri.compareTo(android.net.Uri)");
        return 0;
    }
}
