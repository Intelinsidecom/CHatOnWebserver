package com.samsung.android.sdk.pen.objectruntime.preload;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import java.io.File;

/* loaded from: classes.dex */
public class PhysicsEngineJNI implements IPhysicsEngineJNI {
    public int mNativePhysicsEngine = -1;

    private static native void native_DeInit_JNI(int i);

    private static native void native_Draw_PhysicsEngine(int i);

    private static native int native_Init_JNI();

    private static native void native_Init_PhysicsEngine(int i, int i2, int i3, int i4);

    private static native void native_SetTexture(int i, String str, Bitmap bitmap, boolean z);

    private static native void native_onKeyEvent(int i, int i2);

    private static native void native_onSensorEvent(int i, int i2, float f, float f2, float f3);

    private static native void native_onSettingEvent(int i, int i2, float f);

    private static native void native_onTouchEvent(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2);

    @SuppressLint({"SdCardPath"})
    public PhysicsEngineJNI() {
        IllegalStateException illegalStateException;
        File libFilePath = new File("/data/data/com.samsung.android.sdk.spen30/lib/libSPenPaperEffect.so");
        if (libFilePath.exists()) {
            try {
                System.load("/data/data/com.samsung.android.sdk.spen30/lib/libSPenPaperEffect.so");
            } finally {
                try {
                } catch (Exception e) {
                }
            }
        } else {
            try {
                System.loadLibrary("SPenPaperEffect");
            } catch (Exception e2) {
                throw new IllegalStateException("PaperEffect library is not initialized.");
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.objectruntime.preload.IPhysicsEngineJNI
    public void Init_PhysicsEngineJNI() {
        this.mNativePhysicsEngine = native_Init_JNI();
    }

    @Override // com.samsung.android.sdk.pen.objectruntime.preload.IPhysicsEngineJNI
    public void DeInit_PhysicsEngineJNI() {
        native_DeInit_JNI(this.mNativePhysicsEngine);
    }

    @Override // com.samsung.android.sdk.pen.objectruntime.preload.IPhysicsEngineJNI
    public void Init_PhysicsEngine(int effectType, int width, int height) {
        native_Init_PhysicsEngine(this.mNativePhysicsEngine, effectType, width, height);
    }

    @Override // com.samsung.android.sdk.pen.objectruntime.preload.IPhysicsEngineJNI
    public void Draw_PhysicsEngine() {
        native_Draw_PhysicsEngine(this.mNativePhysicsEngine);
    }

    @Override // com.samsung.android.sdk.pen.objectruntime.preload.IPhysicsEngineJNI
    public void onTouchEvent(int touchID, int touchNum, int eventType, int[] x, int[] y) {
        native_onTouchEvent(this.mNativePhysicsEngine, touchID, touchNum, eventType, x, y);
    }

    @Override // com.samsung.android.sdk.pen.objectruntime.preload.IPhysicsEngineJNI
    public void onSensorEvent(int sensorType, float xValue, float yValue, float zValue) {
        native_onSensorEvent(this.mNativePhysicsEngine, sensorType, xValue, yValue, zValue);
    }

    @Override // com.samsung.android.sdk.pen.objectruntime.preload.IPhysicsEngineJNI
    public void SetTexture(String textureName, Bitmap jbitmap, boolean callback) {
        native_SetTexture(this.mNativePhysicsEngine, textureName, jbitmap, callback);
    }

    @Override // com.samsung.android.sdk.pen.objectruntime.preload.IPhysicsEngineJNI
    public void onKeyEvent(int keyID) {
        native_onKeyEvent(this.mNativePhysicsEngine, keyID);
    }

    @Override // com.samsung.android.sdk.pen.objectruntime.preload.IPhysicsEngineJNI
    public void onSettingEvent(int index, float value) {
        native_onSettingEvent(this.mNativePhysicsEngine, index, value);
    }
}
