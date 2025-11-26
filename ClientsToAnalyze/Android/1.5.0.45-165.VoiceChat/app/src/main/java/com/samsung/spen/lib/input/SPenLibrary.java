package com.samsung.spen.lib.input;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public class SPenLibrary {
    public static SPenEvent getEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            throw new IllegalArgumentException("Event can't be null.");
        }
        return new SPenEvent(motionEvent, true);
    }
}
