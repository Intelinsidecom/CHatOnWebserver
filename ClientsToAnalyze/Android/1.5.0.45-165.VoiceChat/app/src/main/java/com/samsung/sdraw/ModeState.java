package com.samsung.sdraw;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

/* loaded from: classes.dex */
interface ModeState {
    void clearOffscreenBuffer(AbstractModeContext abstractModeContext);

    int getLayerID(AbstractModeContext abstractModeContext);

    boolean isAnimating();

    boolean isFixedBuffer(AbstractModeContext abstractModeContext);

    void onActivate(AbstractModeContext abstractModeContext, boolean z);

    void onDraw(AbstractModeContext abstractModeContext, Canvas canvas);

    void onDraw(AbstractModeContext abstractModeContext, Canvas canvas, int i);

    void onFinishJob(AbstractModeContext abstractModeContext);

    void onFinishJob(AbstractModeContext abstractModeContext, int i);

    void onLayout(AbstractModeContext abstractModeContext, Rect rect);

    boolean onTouchEvent(AbstractModeContext abstractModeContext, MotionEvent motionEvent);

    boolean onTouchEvent(AbstractModeContext abstractModeContext, MotionEvent motionEvent, int i, int i2);

    void setAnimating(boolean z);
}
