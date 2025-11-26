package com.sec.chaton.multimedia.camera;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.util.C1791w;
import java.io.IOException;

/* compiled from: CameraActivity.java */
/* renamed from: com.sec.chaton.multimedia.camera.d */
/* loaded from: classes.dex */
class SurfaceHolderCallbackC0900d extends SurfaceView implements Camera.PictureCallback, SurfaceHolder.Callback, InterfaceC0899c {

    /* renamed from: a */
    SurfaceHolder f3299a;

    /* renamed from: b */
    Camera f3300b;

    /* renamed from: c */
    final /* synthetic */ CameraActivity f3301c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SurfaceHolderCallbackC0900d(CameraActivity cameraActivity, Context context) {
        super(context);
        this.f3301c = cameraActivity;
        this.f3299a = getHolder();
        this.f3299a.addCallback(this);
        this.f3299a.setType(3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) throws IOException {
        this.f3300b = Camera.open();
        try {
            this.f3300b.setPreviewDisplay(surfaceHolder);
        } catch (IOException e) {
            this.f3300b.release();
            this.f3300b = null;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f3300b.stopPreview();
        this.f3300b.release();
        this.f3300b = null;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Camera.Parameters parameters = this.f3300b.getParameters();
        if (this.f3301c.f3294c) {
            parameters.setPreviewSize(i2, i3);
            this.f3300b.setParameters(parameters);
            this.f3300b.startPreview();
        }
    }

    /* renamed from: a */
    public int m3623a(int i) {
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

    @Override // com.sec.chaton.multimedia.camera.InterfaceC0899c
    /* renamed from: a */
    public void mo3622a() {
        Camera.Parameters parameters = this.f3300b.getParameters();
        if (C0452a.f1722a >= 5) {
            int i = this.f3301c.f3296e;
            if (i != -1) {
                i += 90;
            }
            parameters.setRotation(m3623a(i));
        }
        this.f3300b.setParameters(parameters);
        try {
            this.f3300b.takePicture(null, null, this);
        } catch (RuntimeException e) {
            this.f3301c.setResult(0);
            Toast.makeText(this.f3301c, this.f3301c.getString(R.string.toast_fail_camera), 1);
            this.f3301c.finish();
        }
    }

    @Override // android.hardware.Camera.PictureCallback
    public void onPictureTaken(byte[] bArr, Camera camera) {
        Intent intent = new Intent();
        intent.putExtra("URI", C1791w.m6095a(this.f3301c, bArr, 900));
        this.f3301c.setResult(-1, intent);
        this.f3301c.finish();
    }
}
