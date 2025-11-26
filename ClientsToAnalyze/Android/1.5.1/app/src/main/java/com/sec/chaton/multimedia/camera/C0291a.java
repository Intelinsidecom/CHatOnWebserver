package com.sec.chaton.multimedia.camera;

import android.content.Intent;
import android.hardware.Camera;
import com.sec.chaton.trunk.control.TrunkMessageControl;
import com.sec.chaton.util.ChatOnGraphics;

/* renamed from: com.sec.chaton.multimedia.camera.a */
/* loaded from: classes.dex */
class C0291a implements Camera.PictureCallback {

    /* renamed from: a */
    final /* synthetic */ SurfaceHolderCallbackC0292b f2110a;

    C0291a(SurfaceHolderCallbackC0292b surfaceHolderCallbackC0292b) {
        this.f2110a = surfaceHolderCallbackC0292b;
    }

    @Override // android.hardware.Camera.PictureCallback
    public void onPictureTaken(byte[] bArr, Camera camera) {
        Intent intent = new Intent();
        intent.putExtra("URI", ChatOnGraphics.m3537a(this.f2110a.f2113c, bArr, TrunkMessageControl.METHOD_GET_TRUNK_LIST));
        this.f2110a.f2113c.setResult(-1, intent);
        this.f2110a.f2113c.finish();
    }
}
