package com.sec.chaton.multimedia.camera;

import android.content.Context;
import com.sec.chaton.p012c.C0452a;

/* compiled from: CameraActivity.java */
/* renamed from: com.sec.chaton.multimedia.camera.g */
/* loaded from: classes.dex */
public class C0903g {

    /* renamed from: a */
    final /* synthetic */ CameraActivity f3306a;

    /* renamed from: b */
    private InterfaceC0899c f3307b;

    public C0903g(CameraActivity cameraActivity) {
        this.f3306a = cameraActivity;
    }

    /* renamed from: a */
    public InterfaceC0899c m3624a(Context context) {
        if (C0452a.f1722a >= 5) {
            this.f3307b = new SurfaceHolderCallbackC0900d(this.f3306a, context);
        } else {
            this.f3307b = new SurfaceHolderCallbackC0901e(this.f3306a, context);
        }
        return this.f3307b;
    }
}
