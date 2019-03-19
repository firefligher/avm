package android.view;

public class GestureDetector {
    public interface OnContextClickListener {
    }

    public interface OnGestureListener {
    }

    public interface OnDoubleTapListener {
    }

    public static class SimpleOnGestureListener implements GestureDetector.OnGestureListener,
            GestureDetector.OnDoubleTapListener, GestureDetector.OnContextClickListener {

    }
}
