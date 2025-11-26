package com.sec.chaton.multimedia.camera;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.sec.chaton.R;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.util.C1294aq;
import com.sec.widget.C1619g;
import java.io.IOException;

/* compiled from: CameraActivity.java */
/* renamed from: com.sec.chaton.multimedia.camera.e */
/* loaded from: classes.dex */
class SurfaceHolderCallbackC0794e extends SurfaceView implements Camera.PictureCallback, SurfaceHolder.Callback, InterfaceC0796g {

    /* renamed from: a */
    SurfaceHolder f2701a;

    /* renamed from: b */
    Camera f2702b;

    /* renamed from: c */
    final /* synthetic */ CameraActivity f2703c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SurfaceHolderCallbackC0794e(CameraActivity cameraActivity, Context context) {
        super(context);
        this.f2703c = cameraActivity;
        this.f2701a = getHolder();
        this.f2701a.addCallback(this);
        this.f2701a.setType(3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) throws IOException {
        this.f2702b = Camera.open();
        try {
            this.f2702b.setPreviewDisplay(surfaceHolder);
        } catch (IOException e) {
            this.f2702b.release();
            this.f2702b = null;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f2702b.stopPreview();
        this.f2702b.release();
        this.f2702b = null;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Camera.Parameters parameters = this.f2702b.getParameters();
        if (this.f2703c.f2692c) {
            parameters.setPreviewSize(i2, i3);
            this.f2702b.setParameters(parameters);
            this.f2702b.startPreview();
        }
    }

    /* renamed from: a */
    public int m3280a(int i) {
        if (i == -1) {
            i = 0;
        }
        int i2 = i % 360;
        if (i2 < 45) {
            return 0;
        }
        if (i2 < 135) {
            return 90;
        }
        if (i2 < 225) {
            return 180;
        }
        return i2 < 315 ? 270 : 0;
    }

    @Override // com.sec.chaton.multimedia.camera.InterfaceC0796g
    /* renamed from: a */
    public void mo3279a() {
        Camera.Parameters parameters = this.f2702b.getParameters();
        if (C0684a.f2330a >= 5) {
            int i = this.f2703c.f2694e;
            if (i != -1) {
                i += 90;
            }
            parameters.setRotation(m3280a(i));
        }
        this.f2702b.setParameters(parameters);
        try {
            this.f2702b.takePicture(null, null, this);
        } catch (RuntimeException e) {
            this.f2703c.setResult(0);
            C1619g.m5889a(this.f2703c, this.f2703c.getString(R.string.toast_fail_camera), 1);
            this.f2703c.finish();
        }
    }

    @Override // android.hardware.Camera.PictureCallback
    public void onPictureTaken(byte[] bArr, Camera camera) {
        Intent intent = new Intent();
        intent.putExtra("URI", C1294aq.m4507a(this.f2703c, bArr, 900));
        this.f2703c.setResult(-1, intent);
        this.f2703c.finish();
    }
}
