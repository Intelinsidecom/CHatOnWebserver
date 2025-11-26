package com.samsung.spensdk.applistener;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public interface SPenTouchIDListener {
    boolean onDrawingPen(View view, MotionEvent motionEvent, int i, int i2);

    boolean onTouchFinger(View view, MotionEvent motionEvent, int i);

    boolean onTouchPen(View view, MotionEvent motionEvent, int i);

    boolean onTouchPenEraser(View view, MotionEvent motionEvent, int i);
}
