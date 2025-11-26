package com.sec.chaton.p067j;

/* compiled from: NetResultReceiver.java */
/* renamed from: com.sec.chaton.j.u */
/* loaded from: classes.dex */
class RunnableC2470u implements Runnable {

    /* renamed from: a */
    final int f8861a;

    /* renamed from: b */
    final Object f8862b;

    /* renamed from: c */
    final Object f8863c;

    /* renamed from: d */
    final /* synthetic */ C2466q f8864d;

    public RunnableC2470u(C2466q c2466q, int i, Object obj, Object obj2) {
        this.f8864d = c2466q;
        this.f8861a = i;
        this.f8862b = obj;
        this.f8863c = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8864d.m10676b(this.f8861a, this.f8862b, this.f8863c);
    }
}
