package com.facebook.p033c;

/* compiled from: WorkQueue.java */
/* renamed from: com.facebook.c.y */
/* loaded from: classes.dex */
class RunnableC0528y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0504aa f1331a;

    /* renamed from: b */
    final /* synthetic */ C0527x f1332b;

    RunnableC0528y(C0527x c0527x, C0504aa c0504aa) {
        this.f1332b = c0527x;
        this.f1331a = c0504aa;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1331a.m1862c().run();
        } finally {
            this.f1332b.m1911a(this.f1331a);
        }
    }
}
