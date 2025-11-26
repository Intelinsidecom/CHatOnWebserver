package com.facebook.p009c;

/* compiled from: WorkQueue.java */
/* renamed from: com.facebook.c.y */
/* loaded from: classes.dex */
class RunnableC0157y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0133aa f361a;

    /* renamed from: b */
    final /* synthetic */ C0156x f362b;

    RunnableC0157y(C0156x c0156x, C0133aa c0133aa) {
        this.f362b = c0156x;
        this.f361a = c0133aa;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f361a.m419c().run();
        } finally {
            this.f362b.m468a(this.f361a);
        }
    }
}
