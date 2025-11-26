package com.sec.chaton.p067j;

/* compiled from: NetResultReceiver.java */
/* renamed from: com.sec.chaton.j.r */
/* loaded from: classes.dex */
class RunnableC2467r implements Runnable {

    /* renamed from: a */
    final int f8852a;

    /* renamed from: b */
    final Object f8853b;

    /* renamed from: c */
    final /* synthetic */ C2466q f8854c;

    public RunnableC2467r(C2466q c2466q, int i, Object obj) {
        this.f8854c = c2466q;
        this.f8852a = i;
        this.f8853b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8854c.m10675b(this.f8852a, this.f8853b);
    }
}
