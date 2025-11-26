package com.sec.chaton.multimedia.camera;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.IOException;

/* renamed from: com.sec.chaton.multimedia.camera.b */
/* loaded from: classes.dex */
class SurfaceHolderCallbackC0292b extends SurfaceView implements SurfaceHolder.Callback, InterfaceC0296f {

    /* renamed from: a */
    SurfaceHolder f2111a;

    /* renamed from: b */
    Camera f2112b;

    /* renamed from: c */
    final /* synthetic */ CameraActivity f2113c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SurfaceHolderCallbackC0292b(CameraActivity cameraActivity, Context context) {
        super(context);
        this.f2113c = cameraActivity;
        this.f2111a = getHolder();
        this.f2111a.addCallback(this);
        this.f2111a.setType(3);
    }

    @Override // com.sec.chaton.multimedia.camera.InterfaceC0296f
    /* renamed from: a */
    public void mo2509a() {
        this.f2112b.setParameters(this.f2112b.getParameters());
        this.f2112b.takePicture(null, null, new C0291a(this));
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Camera.Parameters parameters = this.f2112b.getParameters();
        if (this.f2113c.f2105c) {
            parameters.setPreviewSize(i2, i3);
            this.f2112b.setParameters(parameters);
            this.f2112b.startPreview();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) throws IOException {
        this.f2112b = Camera.open();
        try {
            this.f2112b.setPreviewDisplay(surfaceHolder);
        } catch (IOException e) {
            this.f2112b.release();
            this.f2112b = null;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f2112b.stopPreview();
        this.f2112b.release();
        this.f2112b = null;
    }
}
