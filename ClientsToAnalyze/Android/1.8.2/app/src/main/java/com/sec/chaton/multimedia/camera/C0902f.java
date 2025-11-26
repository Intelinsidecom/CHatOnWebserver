package com.sec.chaton.multimedia.camera;

import android.content.Intent;
import android.hardware.Camera;
import com.sec.chaton.util.C1791w;

/* compiled from: CameraActivity.java */
/* renamed from: com.sec.chaton.multimedia.camera.f */
/* loaded from: classes.dex */
class C0902f implements Camera.PictureCallback {

    /* renamed from: a */
    final /* synthetic */ SurfaceHolderCallbackC0901e f3305a;

    C0902f(SurfaceHolderCallbackC0901e surfaceHolderCallbackC0901e) {
        this.f3305a = surfaceHolderCallbackC0901e;
    }

    @Override // android.hardware.Camera.PictureCallback
    public void onPictureTaken(byte[] bArr, Camera camera) {
        Intent intent = new Intent();
        intent.putExtra("URI", C1791w.m6095a(this.f3305a.f3304c, bArr, 900));
        this.f3305a.f3304c.setResult(-1, intent);
        this.f3305a.f3304c.finish();
    }
}
