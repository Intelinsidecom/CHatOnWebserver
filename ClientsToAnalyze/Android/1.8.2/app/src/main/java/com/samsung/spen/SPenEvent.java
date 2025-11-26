package com.samsung.spen;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public class SPenEvent {
    public static final int BUTTON_ERASER = 1;
    public static final int BUTTON_NONE = 0;
    public static final int BUTTON_SIDE = 2;
    private static final int META_BUTTON_ERASER = 1024;
    private static final int META_BUTTON_SIDE = 2048;
    private static final int META_PEN_ON = 512;
    private int mMetaState;
    private final MotionEvent mMotionEvent;
    private int mPressedButtons = 0;

    SPenEvent(MotionEvent motionEvent, boolean z) {
        this.mMotionEvent = motionEvent;
        if (DeviceModel.IS_SUPPORTED_DEVICE || !z) {
            this.mMetaState = motionEvent.getMetaState();
            setPressedButtons();
        }
    }

    public float getX() {
        return this.mMotionEvent.getX();
    }

    public float getY() {
        return this.mMotionEvent.getY();
    }

    public float getPressure() {
        return this.mMotionEvent.getPressure();
    }

    public int getPressedButtons() {
        return this.mPressedButtons;
    }

    public boolean isPressedButton(int i) {
        return (this.mPressedButtons & i) != 0;
    }

    public boolean isPen() {
        return (this.mMetaState & 512) != 0;
    }

    private void setPressedButtons() {
        if ((this.mMetaState & 1024) != 0) {
            this.mPressedButtons++;
        }
        if ((this.mMetaState & 2048) != 0) {
            this.mPressedButtons += 2;
        }
    }
}
