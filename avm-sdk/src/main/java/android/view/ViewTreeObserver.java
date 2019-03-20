package android.view;

public final class ViewTreeObserver {
    public interface OnGlobalLayoutListener {
        void onGlobalLayout();
    }

    public interface OnTouchModeChangeListener {
        void onTouchModeChanged(boolean isInTouchMode);
    }

    public interface OnPreDrawListener {
        boolean onPreDraw();
    }

    public interface OnScrollChangedListener {
        void onScrollChanged();
    }
}
