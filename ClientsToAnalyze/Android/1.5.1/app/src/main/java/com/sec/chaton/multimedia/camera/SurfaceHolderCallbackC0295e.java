package com.sec.chaton.multimedia.camera;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.constant.ChatONConst;
import com.sec.chaton.trunk.control.TrunkMessageControl;
import com.sec.chaton.util.ChatOnGraphics;
import java.io.IOException;

/* renamed from: com.sec.chaton.multimedia.camera.e */
/* loaded from: classes.dex */
class SurfaceHolderCallbackC0295e extends SurfaceView implements Camera.PictureCallback, SurfaceHolder.Callback, InterfaceC0296f {

    /* renamed from: a */
    SurfaceHolder f2116a;

    /* renamed from: b */
    Camera f2117b;

    /* renamed from: c */
    final /* synthetic */ CameraActivity f2118c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SurfaceHolderCallbackC0295e(CameraActivity cameraActivity, Context context) {
        super(context);
        this.f2118c = cameraActivity;
        this.f2116a = getHolder();
        this.f2116a.addCallback(this);
        this.f2116a.setType(3);
    }

    /* renamed from: a */
    public int m2510a(int i) {
        int i2 = (i == -1 ? 0 : i) % 360;
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

    @Override // com.sec.chaton.multimedia.camera.InterfaceC0296f
    /* renamed from: a */
    public void mo2509a() {
        Camera.Parameters parameters = this.f2117b.getParameters();
        if (ChatONConst.f1337a >= 5) {
            int i = this.f2118c.f2107e;
            if (i != -1) {
                i += 90;
            }
            parameters.setRotation(m2510a(i));
        }
        this.f2117b.setParameters(parameters);
        try {
            this.f2117b.takePicture(null, null, this);
        } catch (RuntimeException e) {
            this.f2118c.setResult(0);
            Toast.makeText(this.f2118c, this.f2118c.getString(C0062R.string.toast_fail_camera), 1);
            this.f2118c.finish();
        }
    }

    @Override // android.hardware.Camera.PictureCallback
    public void onPictureTaken(byte[] bArr, Camera camera) {
        Intent intent = new Intent();
        intent.putExtra("URI", ChatOnGraphics.m3537a(this.f2118c, bArr, TrunkMessageControl.METHOD_GET_TRUNK_LIST));
        this.f2118c.setResult(-1, intent);
        this.f2118c.finish();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Camera.Parameters parameters = this.f2117b.getParameters();
        if (this.f2118c.f2105c) {
            parameters.setPreviewSize(i2, i3);
            this.f2117b.setParameters(parameters);
            this.f2117b.startPreview();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) throws IOException {
        this.f2117b = Camera.open();
        try {
            this.f2117b.setPreviewDisplay(surfaceHolder);
        } catch (IOException e) {
            this.f2117b.release();
            this.f2117b = null;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f2117b.stopPreview();
        this.f2117b.release();
        this.f2117b = null;
    }
}
