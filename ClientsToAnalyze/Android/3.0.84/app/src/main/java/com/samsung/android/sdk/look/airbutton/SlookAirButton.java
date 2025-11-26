package com.samsung.android.sdk.look.airbutton;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.airbutton.AirButtonImpl;
import com.samsung.android.sdk.look.Slook;

/* loaded from: classes.dex */
public class SlookAirButton {
    public static final int DIRECTION_AUTO = -1;
    public static final int DIRECTION_LEFT = 3;
    public static final int DIRECTION_LOWER = 2;
    public static final int DIRECTION_RIGHT = 4;
    public static final int DIRECTION_UPPER = 1;
    public static final int GRAVITY_AUTO = -1;
    public static final int GRAVITY_BOTTOM = 2;
    public static final int GRAVITY_HOVER_POINT = 5;
    public static final int GRAVITY_LEFT = 3;
    public static final int GRAVITY_RIGHT = 4;
    public static final int GRAVITY_TOP = 1;
    private static final String TAG = "AirButtonWidget";
    public static final int UI_TYPE_LIST = 2;
    public static final int UI_TYPE_MENU = 1;
    private AirButtonImpl mAirButtonImpl;
    private ItemSelectListener mItemSelectListener;
    private Slook mSlook = new Slook();
    private int mUIType;

    public interface ItemSelectListener {
        void onItemSelected(View view, int i, Object obj);
    }

    public SlookAirButton(View view, SlookAirButtonAdapter slookAirButtonAdapter, int i) {
        this.mAirButtonImpl = null;
        this.mUIType = 2;
        if (isSupport(1)) {
            if (slookAirButtonAdapter == null) {
                throw new IllegalArgumentException("adapter is null");
            }
            this.mUIType = i;
            this.mAirButtonImpl = new AirButtonImpl(view, slookAirButtonAdapter, i);
        }
    }

    public void setItemSelectListener(ItemSelectListener itemSelectListener) {
        if (isSupport(1)) {
            this.mItemSelectListener = itemSelectListener;
            this.mAirButtonImpl.setOnItemSelectedListener(new AirButtonImpl.OnItemSelectedListener() { // from class: com.samsung.android.sdk.look.airbutton.SlookAirButton.1
                public void onItemSelected(View view, int i, Object obj) {
                    SlookAirButton.this.mItemSelectListener.onItemSelected(view, i, obj);
                }
            });
        }
    }

    public void setGravity(int i) {
        if (isSupport(1)) {
            this.mAirButtonImpl.setGravity(i);
        }
    }

    public int getGravity() {
        if (isSupport(1)) {
            return this.mAirButtonImpl.getGravity();
        }
        return 0;
    }

    public void setDirection(int i) {
        if (isSupport(1)) {
            if (this.mUIType == 1 && (i == 1 || i == 2)) {
                throw new IllegalStateException("The Direction is wrong.you cann't use UPPER/LOWER direction with UI_TYPE_MENU.");
            }
            if (this.mUIType == 2 && (i == 3 || i == 4)) {
                throw new IllegalStateException("The Direction is wrong.you cann't use LEFT/RIGHT direction with UI_TYPE_LIST.");
            }
            this.mAirButtonImpl.setDirection(i);
        }
    }

    public int getDirection() {
        if (isSupport(1)) {
            return this.mAirButtonImpl.getDirection();
        }
        return 0;
    }

    public void setPosition(int i, int i2) {
        if (isSupport(1)) {
            this.mAirButtonImpl.setPosition(i, i2);
        }
    }

    public void setScrollEnabled(boolean z) {
        if (isSupport(1)) {
            this.mAirButtonImpl.setScrollEnabled(z);
        }
    }

    public boolean isScrollEnabled() {
        if (isSupport(1)) {
            return this.mAirButtonImpl.isScrollEnabled();
        }
        return false;
    }

    private boolean isSupport(int i) {
        if (this.mSlook.getVersionCode() >= i) {
            return true;
        }
        Log.e(TAG, "This is not supported in device");
        return false;
    }

    public void setBounceEffectEnabled(boolean z) {
        if (isSupport(1)) {
            this.mAirButtonImpl.setBounceEffectEnabled(z);
        }
    }

    public boolean isBounceEffectEnabled() {
        if (isSupport(1)) {
            return this.mAirButtonImpl.isBounceEffectEnabled();
        }
        return false;
    }

    public void hide() {
        if (isSupport(1)) {
            this.mAirButtonImpl.hide();
        }
    }

    public void dismiss() {
        if (isSupport(1)) {
            this.mAirButtonImpl.dismiss();
        }
    }

    public void setAutoControlEnabled(boolean z) {
        if (isSupport(1)) {
            this.mAirButtonImpl.setEnabled(z);
        }
    }

    public boolean isAutoControlEnabled() {
        if (isSupport(1)) {
            return this.mAirButtonImpl.isEnabled();
        }
        return false;
    }

    public void startAnimationIcon(MotionEvent motionEvent) {
        if (isSupport(1)) {
            if (this.mAirButtonImpl.isEnabled()) {
                throw new IllegalStateException("The mode is auto control. Please disable auto control.");
            }
            if (motionEvent.getAction() != 9) {
                throw new IllegalArgumentException("The event isn't ACTION_HOVER_ENTER");
            }
            this.mAirButtonImpl.onHoverEnter(motionEvent);
        }
    }

    public void moveAnimationIcon(MotionEvent motionEvent) {
        if (isSupport(1)) {
            if (this.mAirButtonImpl.isEnabled()) {
                throw new IllegalStateException("The mode is auto control. Please disable auto control.");
            }
            if (motionEvent.getAction() != 7) {
                throw new IllegalArgumentException("The event isn't ACTION_HOVER_MOVE.");
            }
            this.mAirButtonImpl.onHoverMove(motionEvent);
        }
    }

    public void stopAnimationIcon(MotionEvent motionEvent) {
        if (isSupport(1)) {
            if (this.mAirButtonImpl.isEnabled()) {
                throw new IllegalStateException("The mode is auto control. Please disable auto control.");
            }
            if (motionEvent.getAction() != 10) {
                throw new IllegalArgumentException("The event isn't ACTION_HOVER_EXIT.");
            }
            this.mAirButtonImpl.onHoverExit(motionEvent);
        }
    }

    public void show(MotionEvent motionEvent) {
        if (isSupport(1)) {
            if (this.mAirButtonImpl.isEnabled()) {
                throw new IllegalStateException("The mode is auto control. Please disable auto control.");
            }
            if (motionEvent.getToolType(0) != 2 || (motionEvent.getButtonState() & 2) == 0) {
                throw new IllegalArgumentException("The event isn't BUTTON_SECONDARY or TOOL_TYPE_STYLUS.");
            }
            this.mAirButtonImpl.onHoverButtonSecondary(motionEvent);
        }
    }
}
