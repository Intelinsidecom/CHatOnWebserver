package com.facebook.p009c;

import android.graphics.Bitmap;

/* compiled from: ImageDownloader.java */
/* renamed from: com.facebook.c.b */
/* loaded from: classes.dex */
final class RunnableC0134b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0139g f299a;

    /* renamed from: b */
    final /* synthetic */ Exception f300b;

    /* renamed from: c */
    final /* synthetic */ boolean f301c;

    /* renamed from: d */
    final /* synthetic */ Bitmap f302d;

    /* renamed from: e */
    final /* synthetic */ InterfaceC0142j f303e;

    RunnableC0134b(C0139g c0139g, Exception exc, boolean z, Bitmap bitmap, InterfaceC0142j interfaceC0142j) {
        this.f299a = c0139g;
        this.f300b = exc;
        this.f301c = z;
        this.f302d = bitmap;
        this.f303e = interfaceC0142j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f303e.mo433a(new C0143k(this.f299a, this.f300b, this.f301c, this.f302d));
    }
}
