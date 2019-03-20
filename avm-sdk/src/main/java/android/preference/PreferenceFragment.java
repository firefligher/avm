package android.preference;

import android.app.Fragment;

public abstract class PreferenceFragment extends Fragment {
    public interface OnPreferenceStartFragmentCallback {
        boolean onPreferenceStartFragment(PreferenceFragment caller, Preference pref);
    }
}
