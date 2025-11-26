package com.coolots.chaton.common.controller;

import android.view.ScaleGestureDetector;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class PinchZoomController implements DisposeInterface, ScaleGestureDetector.OnScaleGestureListener {
    private static final String CLASSNAME = "[PinchZoomController]";
    public static final int LAYOUT_GAP_SIZE = 10;
    public static final int LAYOUT_MIN_SIZE = 200;
    private static final int MAX_ZOOM_LEVEL = 30;
    private static final int ZOOM_VELOCITY = 112;
    private IPinchZoomController mResizeLayout;
    private int newZoomValue = 0;
    private int mPreviousCallbackValue = 0;
    private int mOverValue = 0;
    private int mPreOvervalue = 0;
    private int mInitialZoomValueOnScaleBegin = 1;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public PinchZoomController(IPinchZoomController layout) {
        this.mResizeLayout = layout;
    }

    public float toScale(int size) {
        return 1.0f;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector arg0) {
        int currentCallbackValue = (int) (Math.log10(arg0.getScaleFactor()) * 112.0d);
        if (this.mInitialZoomValueOnScaleBegin + currentCallbackValue > 30 && this.mPreviousCallbackValue < currentCallbackValue) {
            this.mOverValue = (this.mInitialZoomValueOnScaleBegin + currentCallbackValue) - 30;
            if (this.mPreOvervalue > this.mOverValue) {
                this.mOverValue = this.mPreOvervalue;
            }
        } else if (this.mInitialZoomValueOnScaleBegin + currentCallbackValue < 0 && this.mPreviousCallbackValue > currentCallbackValue) {
            this.mOverValue = this.mInitialZoomValueOnScaleBegin + currentCallbackValue;
            if (this.mPreOvervalue < this.mOverValue) {
                this.mOverValue = this.mPreOvervalue;
            }
        }
        this.newZoomValue = (this.mInitialZoomValueOnScaleBegin + currentCallbackValue) - this.mOverValue;
        this.mPreviousCallbackValue = currentCallbackValue;
        this.mPreOvervalue = this.mOverValue;
        if (this.newZoomValue < 0) {
            this.newZoomValue = 0;
        }
        if (this.newZoomValue > 30) {
            this.newZoomValue = 30;
        }
        logI(" newZoomValue: " + this.newZoomValue + " currentCallbackValue: " + currentCallbackValue + " mPreviousCallbackValue: " + this.mPreviousCallbackValue);
        this.mResizeLayout.resizePinchZoomLayout(getSize());
        return false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector arg0) {
        logI("onScaleBegin()");
        this.mInitialZoomValueOnScaleBegin = this.newZoomValue;
        this.mOverValue = 0;
        this.mPreOvervalue = 0;
        this.mPreviousCallbackValue = 0;
        this.mResizeLayout.setVisibilityPinchZoomLayout(true);
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector arg0) {
        logI("onScaleEnd");
        this.mResizeLayout.setVisibilityPinchZoomLayout(false);
    }

    public int getScale() {
        return this.newZoomValue;
    }

    public int getSize() {
        return (this.newZoomValue * 10) + 200;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
    }
}
