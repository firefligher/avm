package android.widget;

import lombok.extern.java.Log;

@Log
public class ListView extends AbsListView {
    @Override
    public void onGlobalLayout() {
        log.warning("Unimplemented method: android.widget.ListView.onGlobalLayout()");
    }

    @Override
    public void onTouchModeChanged(boolean isInTouchMode) {
        log.warning("Unimplemented method: android.widget.ListView.onTouchModeChanged(boolean)");
    }

    @Override
    public void onFilterComplete(int count) {
        log.warning("Unimplemented method: android.widget.ListView.onFilterComplete(int)");
    }
}
