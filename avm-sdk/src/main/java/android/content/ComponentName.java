package android.content;

import android.os.Parcelable;
import lombok.extern.java.Log;

@Log
public final class ComponentName implements Parcelable, Cloneable, Comparable<ComponentName> {
    @Override
    public int compareTo(ComponentName componentName) {
        log.warning("Unimplemented method: android.content.ComponentName.compareTo(android.content.ComponentName)");
        return 0;
    }
}
