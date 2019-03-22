package android.content.res;

import android.os.Parcelable;
import lombok.extern.java.Log;

@Log
public final class Configuration implements Parcelable, Comparable<Configuration> {
    @Override
    public int compareTo(Configuration configuration) {
        log.warning("Unimplemented method: android.content.res.Configuration.compareTo(" +
                "android.content.res.Configuration)");

        return 0;
    }
}
