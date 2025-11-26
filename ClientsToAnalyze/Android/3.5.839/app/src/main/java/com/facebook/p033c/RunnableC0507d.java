package com.facebook.p033c;

import android.content.Context;

/* compiled from: ImageDownloader.java */
/* renamed from: com.facebook.c.d */
/* loaded from: classes.dex */
class RunnableC0507d implements Runnable {

    /* renamed from: a */
    private Context f1276a;

    /* renamed from: b */
    private C0509f f1277b;

    RunnableC0507d(Context context, C0509f c0509f) {
        this.f1276a = context;
        this.f1277b = c0509f;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        C0503a.m1854b(this.f1277b, this.f1276a);
    }
}
