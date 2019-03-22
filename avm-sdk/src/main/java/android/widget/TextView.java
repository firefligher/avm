package android.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import lombok.extern.java.Log;

@Log
public class TextView extends View implements ViewTreeObserver.OnPreDrawListener {
    @Override
    public boolean onPreDraw() {
        log.warning("Unimplemented method: android.widget.TextView.onPreDraw()");
        return false;
    }
}
