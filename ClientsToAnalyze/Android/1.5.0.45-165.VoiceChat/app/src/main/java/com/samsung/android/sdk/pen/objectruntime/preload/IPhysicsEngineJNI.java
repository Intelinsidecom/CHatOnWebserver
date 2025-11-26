package com.samsung.android.sdk.pen.objectruntime.preload;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public interface IPhysicsEngineJNI {
    void DeInit_PhysicsEngineJNI();

    void Draw_PhysicsEngine();

    void Init_PhysicsEngine(int i, int i2, int i3);

    void Init_PhysicsEngineJNI();

    void SetTexture(String str, Bitmap bitmap, boolean z);

    void onKeyEvent(int i);

    void onSensorEvent(int i, float f, float f2, float f3);

    void onSettingEvent(int i, float f);

    void onTouchEvent(int i, int i2, int i3, int[] iArr, int[] iArr2);
}
