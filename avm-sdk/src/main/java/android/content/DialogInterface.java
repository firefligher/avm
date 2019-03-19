package android.content;

import android.view.KeyEvent;

public interface DialogInterface {
    interface OnClickListener {
        void onClick(DialogInterface dialog, int which);
    }

    interface OnKeyListener {
        boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event);
    }

    interface OnCancelListener {
        void onCancel(DialogInterface dialog);
    }

    void cancel();
    void dismiss();
}
