package android.widget;

import android.view.View;

public class ViewSwitcher extends ViewAnimator {
    public interface ViewFactory {
        View makeView();
    }
}
