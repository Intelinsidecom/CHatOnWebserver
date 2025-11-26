package com.samsung.spensdk.applistener;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public interface SPenHoverListener {
    boolean onHover(View view, MotionEvent motionEvent);

    void onHoverButtonDown(View view, MotionEvent motionEvent);

    void onHoverButtonUp(View view, MotionEvent motionEvent);
}
