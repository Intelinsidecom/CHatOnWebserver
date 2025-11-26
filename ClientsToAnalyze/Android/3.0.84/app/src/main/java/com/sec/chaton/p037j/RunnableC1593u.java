package com.sec.chaton.p037j;

/* compiled from: NetResultReceiver.java */
/* renamed from: com.sec.chaton.j.u */
/* loaded from: classes.dex */
class RunnableC1593u implements Runnable {

    /* renamed from: a */
    final int f5913a;

    /* renamed from: b */
    final Object f5914b;

    /* renamed from: c */
    final Object f5915c;

    /* renamed from: d */
    final /* synthetic */ C1589q f5916d;

    public RunnableC1593u(C1589q c1589q, int i, Object obj, Object obj2) {
        this.f5916d = c1589q;
        this.f5913a = i;
        this.f5914b = obj;
        this.f5915c = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5916d.m6732b(this.f5913a, this.f5914b, this.f5915c);
    }
}
