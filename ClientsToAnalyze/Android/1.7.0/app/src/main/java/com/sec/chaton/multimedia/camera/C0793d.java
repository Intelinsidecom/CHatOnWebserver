package com.sec.chaton.multimedia.camera;

import android.content.Context;
import android.view.OrientationEventListener;

/* compiled from: CameraActivity.java */
/* renamed from: com.sec.chaton.multimedia.camera.d */
/* loaded from: classes.dex */
class C0793d extends OrientationEventListener {

    /* renamed from: a */
    final /* synthetic */ CameraActivity f2700a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0793d(CameraActivity cameraActivity, Context context) {
        super(context);
        this.f2700a = cameraActivity;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        if (i != -1) {
            this.f2700a.f2694e = i;
        }
    }
}
