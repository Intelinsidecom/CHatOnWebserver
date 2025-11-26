package com.sec.chaton.p018c;

/* compiled from: NetResultReceiver.java */
/* renamed from: com.sec.chaton.c.b */
/* loaded from: classes.dex */
class RunnableC0479b implements Runnable {

    /* renamed from: a */
    final int f1540a;

    /* renamed from: b */
    final Object f1541b;

    /* renamed from: c */
    final /* synthetic */ C0490c f1542c;

    public RunnableC0479b(C0490c c0490c, int i, Object obj) {
        this.f1542c = c0490c;
        this.f1540a = i;
        this.f1541b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1542c.m2491b(this.f1540a, this.f1541b);
    }
}
