package com.sec.chaton.multimedia.camera;

import android.content.Context;
import com.sec.chaton.p029f.C0684a;

/* compiled from: CameraActivity.java */
/* renamed from: com.sec.chaton.multimedia.camera.f */
/* loaded from: classes.dex */
public class C0795f {

    /* renamed from: a */
    final /* synthetic */ CameraActivity f2704a;

    /* renamed from: b */
    private InterfaceC0796g f2705b;

    public C0795f(CameraActivity cameraActivity) {
        this.f2704a = cameraActivity;
    }

    /* renamed from: a */
    public InterfaceC0796g m3281a(Context context) {
        if (C0684a.f2330a >= 5) {
            this.f2705b = new SurfaceHolderCallbackC0794e(this.f2704a, context);
        } else {
            this.f2705b = new SurfaceHolderCallbackC0791b(this.f2704a, context);
        }
        return this.f2705b;
    }
}
