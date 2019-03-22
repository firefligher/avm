package android.widget;

import lombok.extern.java.Log;

@Log
public class CompoundButton extends Button implements Checkable {
    public interface OnCheckedChangeListener {
        void onCheckedChanged(CompoundButton buttonView, boolean isChecked);
    }

    @Override
    public boolean isChecked() {
        log.warning("Unimplemented method: android.widget.CompoundButton.isChecked()");
        return false;
    }

    @Override
    public void setChecked(boolean checked) {
        log.warning("Unimplemented method: android.widget.CompoundButton.setChecked(boolean)");
    }

    @Override
    public void toggle() {
        log.warning("Unimplemented method: android.widget.CompoundButton.toggle()");
    }
}
