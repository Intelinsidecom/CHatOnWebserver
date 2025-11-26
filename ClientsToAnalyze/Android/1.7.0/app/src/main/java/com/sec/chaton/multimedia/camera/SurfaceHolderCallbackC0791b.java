package com.sec.chaton.multimedia.camera;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.IOException;

/* compiled from: CameraActivity.java */
/* renamed from: com.sec.chaton.multimedia.camera.b */
/* loaded from: classes.dex */
class SurfaceHolderCallbackC0791b extends SurfaceView implements SurfaceHolder.Callback, InterfaceC0796g {

    /* renamed from: a */
    SurfaceHolder f2696a;

    /* renamed from: b */
    Camera f2697b;

    /* renamed from: c */
    final /* synthetic */ CameraActivity f2698c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SurfaceHolderCallbackC0791b(CameraActivity cameraActivity, Context context) {
        super(context);
        this.f2698c = cameraActivity;
        this.f2696a = getHolder();
        this.f2696a.addCallback(this);
        this.f2696a.setType(3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) throws IOException {
        this.f2697b = Camera.open();
        try {
            this.f2697b.setPreviewDisplay(surfaceHolder);
        } catch (IOException e) {
            this.f2697b.release();
            this.f2697b = null;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f2697b.stopPreview();
        this.f2697b.release();
        this.f2697b = null;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Camera.Parameters parameters = this.f2697b.getParameters();
        if (this.f2698c.f2692c) {
            parameters.setPreviewSize(i2, i3);
            this.f2697b.setParameters(parameters);
            this.f2697b.startPreview();
        }
    }

    @Override // com.sec.chaton.multimedia.camera.InterfaceC0796g
    /* renamed from: a */
    public void mo3279a() {
        this.f2697b.setParameters(this.f2697b.getParameters());
        this.f2697b.takePicture(null, null, new C0790a(this));
    }
}
