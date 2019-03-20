package android.content;

import android.view.KeyEvent;

public interface DialogInterface {
    interface OnCancelListener {
        void onCancel(DialogInterface dialog);
    }

    interface OnClickListener {
        void onClick(DialogInterface dialog, int which);
    }

    interface OnDismissListener {
        void onDismiss(DialogInterface dialog);
    }

    interface OnKeyListener {
        boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event);
    }

    interface OnMultiChoiceClickListener {
        void onClick(DialogInterface dialog, int which, boolean isChecked);
    }

    interface OnShowListener {
        void onShow(DialogInterface dialog);
    }

    int BUTTON1 = 0xFFFFFFFF;
    int BUTTON2 = 0xFFFFFFFE;
    int BUTTON3 = 0xFFFFFFFD;

    int BUTTON_NEGATIVE = 0xFFFFFFFE;
    int BUTTON_NEUTRAL = 0xFFFFFFFD;
    int BUTTON_POSITIVE = 0xFFFFFFFF;

    void cancel();
    void dismiss();
}
