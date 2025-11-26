package com.coolots.chaton.call.screenshare.util;

import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class ScreenShareScale {
    private static final String CLASSNAME = "[ScreenShareScale]";
    public static ScreenShareScale mInstance;
    private WindowManager windowManager;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private float mExpandScaleX = 1.0f;
    private float mExpandScaleY = 1.0f;
    private float mFullHD_X = 1080.0f;
    private float mFullHD_Y = 1920.0f;

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public ScreenShareScale() {
        logI("ScreenShareRatio()");
    }

    public static synchronized ScreenShareScale getInstance() {
        logI("getInstance");
        if (mInstance == null) {
            logI("ScreenShareProc() mInstance == null");
            mInstance = new ScreenShareScale();
        }
        return mInstance;
    }

    public void initScaleData() {
        if (this.windowManager == null) {
            this.windowManager = (WindowManager) MainApplication.mContext.getSystemService("window");
        }
        Display diplay = this.windowManager.getDefaultDisplay();
        setDisplayScale(diplay.getWidth(), diplay.getHeight(), getRotaionDegree());
    }

    private int getRotaionDegree() {
        if (this.windowManager == null) {
            this.windowManager = (WindowManager) MainApplication.mContext.getSystemService("window");
        }
        return ((4 - this.windowManager.getDefaultDisplay().getRotation()) % 4) * 90;
    }

    public void setDisplayScale(int displayWidth, int displayHeight, int getRotaionDegree) {
        if ((displayWidth == 1080 && displayHeight == 1920) || (displayWidth == 1920 && displayHeight == 1080)) {
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mExpandScaleX = 1.0f;
            this.mExpandScaleY = 1.0f;
        } else if (getRotaionDegree == 0 || getRotaionDegree == 2) {
            this.mScaleX = displayWidth / this.mFullHD_X;
            this.mScaleY = displayHeight / this.mFullHD_Y;
            this.mExpandScaleX = this.mFullHD_X / displayWidth;
            this.mExpandScaleY = this.mFullHD_Y / displayHeight;
        } else {
            this.mScaleX = displayHeight / this.mFullHD_X;
            this.mScaleY = displayWidth / this.mFullHD_Y;
            this.mExpandScaleX = this.mFullHD_X / displayHeight;
            this.mExpandScaleY = this.mFullHD_Y / displayWidth;
        }
        logI("setDisplayScale mScaleX : " + this.mScaleX + " mSacleY: " + this.mScaleY + " mExpandScaleX: " + this.mExpandScaleX + " mExpandScaleY: " + this.mExpandScaleY);
    }

    public float modifyScaleX(float getRawX) {
        return this.mScaleX * getRawX;
    }

    public float modifyScaleY(float getRawY) {
        return this.mScaleY * getRawY;
    }

    public float modifyScalePress(float getPress) {
        return this.mScaleX * getPress;
    }

    public float modifyExpandScaleX(float getRawX) {
        return this.mExpandScaleX * getRawX;
    }

    public float modifyExpandScaleY(float getRawY) {
        return this.mExpandScaleY * getRawY;
    }

    public MotionEvent.PointerCoords modifyFHDPointerCoords(MotionEvent.PointerCoords pointerCoords) {
        if (pointerCoords != null) {
            pointerCoords.x *= this.mScaleX;
            pointerCoords.y *= this.mScaleY;
        }
        return pointerCoords;
    }
}
