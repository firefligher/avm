package android.view;

public abstract class ActionMode {
    public interface Callback {
        boolean onActionItemClicked(ActionMode mode, MenuItem item);

        boolean onCreateActionMode(ActionMode mode, Menu menu);

        void onDestroyActionMode(ActionMode mode);

        boolean onPrepareActionMode(ActionMode mode, Menu menu);
    }

    public static abstract class Callback2 implements Callback {

    }
}
