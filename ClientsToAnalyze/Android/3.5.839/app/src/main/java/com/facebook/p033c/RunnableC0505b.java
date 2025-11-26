package com.facebook.p033c;

import android.graphics.Bitmap;

/* compiled from: ImageDownloader.java */
/* renamed from: com.facebook.c.b */
/* loaded from: classes.dex */
final class RunnableC0505b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0510g f1268a;

    /* renamed from: b */
    final /* synthetic */ Exception f1269b;

    /* renamed from: c */
    final /* synthetic */ boolean f1270c;

    /* renamed from: d */
    final /* synthetic */ Bitmap f1271d;

    /* renamed from: e */
    final /* synthetic */ InterfaceC0513j f1272e;

    RunnableC0505b(C0510g c0510g, Exception exc, boolean z, Bitmap bitmap, InterfaceC0513j interfaceC0513j) {
        this.f1268a = c0510g;
        this.f1269b = exc;
        this.f1270c = z;
        this.f1271d = bitmap;
        this.f1272e = interfaceC0513j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1272e.mo1876a(new C0514k(this.f1268a, this.f1269b, this.f1270c, this.f1271d));
    }
}
