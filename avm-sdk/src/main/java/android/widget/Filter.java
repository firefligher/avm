package android.widget;

public abstract class Filter {
    public interface FilterListener {
        void onFilterComplete(int count);
    }
}
