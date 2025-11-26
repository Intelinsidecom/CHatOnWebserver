package com.samsung.spensdk.applistener;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public interface SPenTouchListener {
    void onTouchButtonDown(View view, MotionEvent motionEvent);

    void onTouchButtonUp(View view, MotionEvent motionEvent);

    boolean onTouchFinger(View view, MotionEvent motionEvent);

    boolean onTouchPen(View view, MotionEvent motionEvent);

    boolean onTouchPenEraser(View view, MotionEvent motionEvent);
}
