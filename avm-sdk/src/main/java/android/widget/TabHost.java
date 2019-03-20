package android.widget;

import android.content.Intent;
import android.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import lombok.extern.java.Log;

@Log
public class TabHost extends FrameLayout implements ViewTreeObserver.OnTouchModeChangeListener {
    public interface OnTabChangeListener {
        void onTabChanged(String tabId);
    }

    public interface TabContentFactory {
        View createTabContent(String tag);
    }

    public class TabSpec {
        public String getTag() {
            log.warning("Unimplemented method: android.widget.TabHost$TabSpec.getTag()");
            return null;
        }

        public TabSpec setContent(Intent intent) {
            log.warning("Unimplemented method: android.widget.TabHost$TabSpec.setContent(android.content.Intent)");
            return null;
        }

        public TabSpec setContent(TabContentFactory contentFactory) {
            log.warning("Unimplemented method: android.widget.TabHost$TabSpec.setContent(" +
                    "android.widget.TabHost$TabContentFactory)");
            return null;
        }

        public TabSpec setContent(int viewId) {
            log.warning("Unimplemented method: android.widget.TabHost$TabSpec.setContent(int)");
            return null;
        }

        public TabSpec setIndicator(View view) {
            log.warning("Unimplemented method: android.widget.TabHost$TabSpec.setIndicator(android.view.View)");
            return null;
        }

        public TabSpec setIndicator(CharSequence label) {
            log.warning("Unimplemented method: android.widget.TabHost$TabSpec.setIndicator(java.lang.CharSequence)");
            return null;
        }

        public TabSpec setIndicator(CharSequence label, Drawable icon) {
            log.warning("Unimplemented method: android.widget.TabHost$TabSpec.setIndicator(java.lang.CharSequence, " +
                    "android.drawable.Drawable)");

            return null;
        }
    }

    @Override
    public void onTouchModeChanged(boolean isInTouchMode) {
        log.warning("Unimplemented method: android.widget.TabHost.onTouchModeChanged(boolean)");
    }
}
