package com.samsung.spen.lib.input;

import android.os.Build;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public class SPenEvent {

    /* renamed from: a */
    private final MotionEvent f2032a;

    /* renamed from: b */
    private int f2033b;

    /* renamed from: c */
    private String f2034c = Build.VERSION.RELEASE;

    SPenEvent(MotionEvent motionEvent, boolean z) {
        this.f2032a = motionEvent;
        if (this.f2034c != null) {
            if (this.f2034c.startsWith("4.")) {
                if (motionEvent.getToolType(motionEvent.getPointerCount() - 1) == 1) {
                    this.f2033b = 0;
                    return;
                }
                if (motionEvent.getToolType(motionEvent.getPointerCount() - 1) == 2) {
                    this.f2033b = 512;
                    return;
                } else if (motionEvent.getToolType(motionEvent.getPointerCount() - 1) == 4) {
                    this.f2033b = 1024;
                    return;
                } else {
                    this.f2033b = 0;
                    return;
                }
            }
            this.f2033b = motionEvent.getMetaState();
        }
    }

    public float getX() {
        return this.f2032a.getX();
    }

    public float getY() {
        return this.f2032a.getY();
    }

    public float getPressure() {
        return this.f2032a.getPressure();
    }

    public boolean isSideButtonPressed() {
        if (this.f2034c != null) {
            return this.f2034c.startsWith("4.") ? this.f2032a.getButtonState() == 2 : this.f2033b == 2560;
        }
        return false;
    }

    public boolean isFinger() {
        return this.f2033b == 0;
    }

    public boolean isPen() {
        return this.f2033b == 512 || this.f2033b == 2560;
    }

    public boolean isEraserPen() {
        return this.f2033b == 1024;
    }
}
