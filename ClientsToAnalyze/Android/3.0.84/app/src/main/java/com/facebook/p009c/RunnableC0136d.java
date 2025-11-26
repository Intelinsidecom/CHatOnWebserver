package com.facebook.p009c;

import android.content.Context;

/* compiled from: ImageDownloader.java */
/* renamed from: com.facebook.c.d */
/* loaded from: classes.dex */
class RunnableC0136d implements Runnable {

    /* renamed from: a */
    private Context f307a;

    /* renamed from: b */
    private C0138f f308b;

    RunnableC0136d(Context context, C0138f c0138f) {
        this.f307a = context;
        this.f308b = c0138f;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        C0132a.m411b(this.f308b, this.f307a);
    }
}
