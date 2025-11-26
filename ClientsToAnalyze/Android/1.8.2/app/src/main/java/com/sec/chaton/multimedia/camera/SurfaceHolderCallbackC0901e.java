package com.sec.chaton.multimedia.camera;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.IOException;

/* compiled from: CameraActivity.java */
/* renamed from: com.sec.chaton.multimedia.camera.e */
/* loaded from: classes.dex */
class SurfaceHolderCallbackC0901e extends SurfaceView implements SurfaceHolder.Callback, InterfaceC0899c {

    /* renamed from: a */
    SurfaceHolder f3302a;

    /* renamed from: b */
    Camera f3303b;

    /* renamed from: c */
    final /* synthetic */ CameraActivity f3304c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SurfaceHolderCallbackC0901e(CameraActivity cameraActivity, Context context) {
        super(context);
        this.f3304c = cameraActivity;
        this.f3302a = getHolder();
        this.f3302a.addCallback(this);
        this.f3302a.setType(3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) throws IOException {
        this.f3303b = Camera.open();
        try {
            this.f3303b.setPreviewDisplay(surfaceHolder);
        } catch (IOException e) {
            this.f3303b.release();
            this.f3303b = null;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f3303b.stopPreview();
        this.f3303b.release();
        this.f3303b = null;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Camera.Parameters parameters = this.f3303b.getParameters();
        if (this.f3304c.f3294c) {
            parameters.setPreviewSize(i2, i3);
            this.f3303b.setParameters(parameters);
            this.f3303b.startPreview();
        }
    }

    @Override // com.sec.chaton.multimedia.camera.InterfaceC0899c
    /* renamed from: a */
    public void mo3622a() {
        this.f3303b.setParameters(this.f3303b.getParameters());
        this.f3303b.takePicture(null, null, new C0902f(this));
    }
}
