package android.widget;

public class RadioGroup extends LinearLayout {
    public interface OnCheckedChangeListener {
        void onCheckedChanged(RadioGroup group, int checkedId);
    }
}
