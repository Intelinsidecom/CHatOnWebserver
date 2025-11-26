package android.support.v4.app;

import android.content.res.Resources;

/* renamed from: android.support.v4.app.b */
/* loaded from: classes.dex */
class RunnableC0001b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f26a;

    /* renamed from: b */
    final /* synthetic */ int f27b;

    /* renamed from: c */
    final /* synthetic */ C0015p f28c;

    RunnableC0001b(C0015p c0015p, int i, int i2) {
        this.f28c = c0015p;
        this.f26a = i;
        this.f27b = i2;
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        this.f28c.m87a(this.f28c.f88o.mHandler, (String) null, this.f26a, this.f27b);
    }
}
