package android.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import lombok.extern.java.Log;

public abstract class AbsListView extends AdapterView<ListAdapter> implements TextWatcher,
        ViewTreeObserver.OnGlobalLayoutListener, Filter.FilterListener, ViewTreeObserver.OnTouchModeChangeListener {
    @Log
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);

            log.warning("Unimplemented method: android.widget.AbsListView$LayoutParams.LayoutParams(" +
                    "android.content.Context, android.util.AttributeSet)");
        }

        public LayoutParams(int w, int h) {
            super(w, h);

            log.warning("Unimplemented method: android.widget.AbsListView$LayoutParams.LayoutParams(int, int)");
        }

        public LayoutParams(int w, int h, int viewType) {
            super(w, h);

            log.warning("Unimplemented method: android.widget.AbsListView$LayoutParams.LayoutParams(int, int, int)");
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);

            log.warning("Unimplemented method: android.widget.AbsListView$LayoutParams.LayoutParams(" +
                    "android.view.ViewGroup$LayoutParams)");
        }
    }

    public interface MultiChoiceModeListener extends ActionMode.Callback {
        void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked);
    }

    public interface OnScrollListener {
        int SCROLL_STATE_FLING = 0x00000002;
        int SCROLL_STATE_IDLE = 0x00000000;
        int SCROLL_STATE_TOUCH_SCROLL = 0x00000001;

        void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount);

        void onScrollStateChanged(AbsListView view, int scrollState);
    }

    public interface RecyclerListener {
        void onMovedToScrapHeap(View view);
    }

    public interface SelectionBoundsAdjuster {
        void adjustListItemSelectionBounds(Rect bounds);
    }
}
