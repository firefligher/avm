package android.preference;

import android.view.AbsSavedState;
import lombok.extern.java.Log;

@Log
public class Preference implements Comparable<Preference> {
    public static class BaseSavedState extends AbsSavedState {
    }

    public interface OnPreferenceChangeListener {
        boolean onPreferenceChange(Preference preference, Object newValue);
    }

    public interface OnPreferenceClickListener {
        boolean onPreferenceClick(Preference preference);
    }

    @Override
    public int compareTo(Preference preference) {
        log.warning("Unimplemented method: android.preference.Preference.compareTo(android.preference.Preference)");
        return 0;
    }
}
