package com.sec.chaton.multimedia.camera;

import android.content.Context;
import android.view.OrientationEventListener;

/* renamed from: com.sec.chaton.multimedia.camera.d */
/* loaded from: classes.dex */
class C0294d extends OrientationEventListener {

    /* renamed from: a */
    final /* synthetic */ CameraActivity f2115a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0294d(CameraActivity cameraActivity, Context context) {
        super(context);
        this.f2115a = cameraActivity;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        if (i != -1) {
            this.f2115a.f2107e = i;
        }
    }
}
