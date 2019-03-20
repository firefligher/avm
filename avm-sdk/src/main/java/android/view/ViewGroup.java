package android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.LayoutAnimationController;
import lombok.extern.java.Log;

public abstract class ViewGroup extends View implements ViewParent, ViewManager {
    @Log
    public static class LayoutParams {
        public int height;
        public LayoutAnimationController.AnimationParameters layoutAnimationParameters;
        public int width;

        public LayoutParams(Context c, AttributeSet attrs) {
            log.warning("Unimplemented method: android.view.ViewGroup$LayoutParams.LayoutParams(" +
                    "android.content.Context, android.util.AttributeSet)");
        }

        public LayoutParams(int width, int height) {
            log.warning("Unimplemented method: android.view.ViewGroup$LayoutParams.LayoutParams(int, int)");
        }

        public LayoutParams(LayoutParams source) {
            log.warning("Unimplemented method: android.view.ViewGroup$LayoutParams.LayoutParams(" +
                    "android.view.ViewGroup$LayoutParams)");
        }

        public void resolveLayoutDirection(int layoutDirection) {
            log.warning("Unimplemented method: android.view.ViewGroup$LayoutParams.resolveLayoutDirection(int)");
        }

        protected void setBaseAttributes(TypedArray a, int widthAttr, int heightAttr) {
            log.warning("Unimplemented method: android.view.ViewGroup$LayoutParams.setBaseAttributes(" +
                    "android.content.res.TypedArray, int, int)");
        }
    }
}
