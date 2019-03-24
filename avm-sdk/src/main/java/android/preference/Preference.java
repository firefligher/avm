package android.preference;

import android.os.Parcel;
import android.view.AbsSavedState;
import lombok.extern.java.Log;

@Log
public class Preference implements Comparable<Preference> {
    public static class BaseSavedState extends AbsSavedState {
        @Override
        public int describeContents() {
            log.warning("android.preference.Preference$BaseSavedState.describeContents()");
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            log.warning("android.preference.Preference$BaseSavedState.writeToParcel(android.os.Parcel, int)");
        }
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
