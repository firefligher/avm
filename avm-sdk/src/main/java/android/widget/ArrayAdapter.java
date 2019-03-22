package android.widget;

import android.view.View;
import android.view.ViewGroup;
import lombok.extern.java.Log;

@Log
public class ArrayAdapter<T> extends BaseAdapter implements Filterable, ThemedSpinnerAdapter {
    @Override
    public Filter getFilter() {
        log.warning("Unimplemented method: android.widget.ArrayAdapter.getFilter()");
        return null;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        log.warning("Unimplemented method: android.widget.ArrayAdapter.getDropDownView(int, android.view.View, " +
                "android.view.ViewGroup)");

        return null;
    }
}
