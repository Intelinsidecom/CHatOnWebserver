package com.sec.chaton.p022h;

/* compiled from: NetResultReceiver.java */
/* renamed from: com.sec.chaton.h.r */
/* loaded from: classes.dex */
class RunnableC0808r implements Runnable {

    /* renamed from: a */
    final int f2969a;

    /* renamed from: b */
    final Object f2970b;

    /* renamed from: c */
    final Object f2971c;

    /* renamed from: d */
    final /* synthetic */ C0805o f2972d;

    public RunnableC0808r(C0805o c0805o, int i, Object obj, Object obj2) {
        this.f2972d = c0805o;
        this.f2969a = i;
        this.f2970b = obj;
        this.f2971c = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2972d.m3419b(this.f2969a, this.f2970b, this.f2971c);
    }
}
