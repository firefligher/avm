package android.widget;

import android.text.TextWatcher;
import android.view.ViewTreeObserver;

public abstract class AbsListView extends AdapterView<ListAdapter> implements TextWatcher,
        ViewTreeObserver.OnGlobalLayoutListener, Filter.FilterListener, ViewTreeObserver.OnTouchModeChangeListener {
}
