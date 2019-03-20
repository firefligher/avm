package android.widget;

import lombok.extern.java.Log;

@Log
public class GridView extends AbsListView {
    @Override
    public void onGlobalLayout() {
        log.warning("Unimplemented method: android.widget.GridView.onGlobalLayout()");
    }

    @Override
    public void onTouchModeChanged(boolean isInTouchMode) {
        log.warning("Unimplemented method: android.widget.GridView.onTouchModeChanged(boolean)");
    }

    @Override
    public void onFilterComplete(int count) {
        log.warning("Unimplemented method: android.widget.GridView.onFilterComplete()");
    }
}
