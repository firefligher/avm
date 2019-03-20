package android.view;

import lombok.extern.java.Log;

public class ScaleGestureDetector {
    @Log
    public static class SimpleOnScaleGestureListener implements ScaleGestureDetector.OnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            log.warning("Unimplemented method: android.view.ScaleGestureDetector$SimpleOnScaleGestureListener.onScale(" +
                    "android.view.ScaleGestureDetector)");

            return false;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            log.warning("Unimplemented method: android.view.ScaleGestureDetector$SimpleOnScaleGestureListener" +
                    ".onScaleBegin(android.view.ScaleGestureDetector)");

            return false;
        }

        @Override
        public boolean onScaleEnd(ScaleGestureDetector detector) {
            log.warning("Unimplemented method: android.view.ScaleGestureDetector$SimpleOnScaleGestureListener" +
                    ".onScaleEnd(android.view.ScaleGestureDetector)");

            return false;
        }
    }

    public interface OnScaleGestureListener {
        boolean onScale(ScaleGestureDetector detector);

        boolean onScaleBegin(ScaleGestureDetector detector);

        boolean onScaleEnd(ScaleGestureDetector detector);
    }
}
