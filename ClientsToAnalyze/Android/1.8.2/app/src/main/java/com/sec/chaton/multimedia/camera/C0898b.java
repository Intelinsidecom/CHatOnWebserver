package com.sec.chaton.multimedia.camera;

import android.content.Context;
import android.view.OrientationEventListener;

/* compiled from: CameraActivity.java */
/* renamed from: com.sec.chaton.multimedia.camera.b */
/* loaded from: classes.dex */
class C0898b extends OrientationEventListener {

    /* renamed from: a */
    final /* synthetic */ CameraActivity f3298a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0898b(CameraActivity cameraActivity, Context context) {
        super(context);
        this.f3298a = cameraActivity;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        if (i != -1) {
            this.f3298a.f3296e = i;
        }
    }
}
