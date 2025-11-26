package com.sec.chaton.multimedia.camera;

import android.content.Intent;
import android.hardware.Camera;
import com.sec.chaton.util.C1294aq;

/* compiled from: CameraActivity.java */
/* renamed from: com.sec.chaton.multimedia.camera.a */
/* loaded from: classes.dex */
class C0790a implements Camera.PictureCallback {

    /* renamed from: a */
    final /* synthetic */ SurfaceHolderCallbackC0791b f2695a;

    C0790a(SurfaceHolderCallbackC0791b surfaceHolderCallbackC0791b) {
        this.f2695a = surfaceHolderCallbackC0791b;
    }

    @Override // android.hardware.Camera.PictureCallback
    public void onPictureTaken(byte[] bArr, Camera camera) {
        Intent intent = new Intent();
        intent.putExtra("URI", C1294aq.m4507a(this.f2695a.f2698c, bArr, 900));
        this.f2695a.f2698c.setResult(-1, intent);
        this.f2695a.f2698c.finish();
    }
}
