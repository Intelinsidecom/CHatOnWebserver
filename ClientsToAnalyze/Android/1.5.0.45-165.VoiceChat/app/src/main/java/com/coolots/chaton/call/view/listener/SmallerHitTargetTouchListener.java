package com.coolots.chaton.call.view.listener;

import android.view.MotionEvent;
import android.view.View;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class SmallerHitTargetTouchListener implements View.OnTouchListener {
    private static final int HIT_TARGET_PERCENT_X = 50;
    private static final int HIT_TARGET_PERCENT_Y = 80;
    private static final int X_EDGE = 25;
    private static final int X_HIT_MAX = 75;
    private static final int X_HIT_MIN = 25;
    private static final int Y_EDGE = 10;
    private static final int Y_HIT_MAX = 90;
    private static final int Y_HIT_MIN = 10;
    boolean mDownEventHit;

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        if (event.getAction() != 0) {
            return !this.mDownEventHit;
        }
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();
        int viewWidth = view.getWidth();
        int viewHeight = view.getHeight();
        int touchXPercent = (int) ((touchX * 100) / viewWidth);
        int touchYPercent = (int) ((touchY * 100) / viewHeight);
        if (touchXPercent < 25 || touchXPercent > 75 || touchYPercent < 10 || touchYPercent > Y_HIT_MAX) {
            Log.m2958e("<<------------- DROP TOUCH EVENT ------------------->>");
            this.mDownEventHit = false;
            return true;
        }
        this.mDownEventHit = true;
        return false;
    }
}
