package com.sec.chaton.p018c;

/* compiled from: NetResultReceiver.java */
/* renamed from: com.sec.chaton.c.g */
/* loaded from: classes.dex */
class RunnableC0500g implements Runnable {

    /* renamed from: a */
    final int f1613a;

    /* renamed from: b */
    final Object f1614b;

    /* renamed from: c */
    final Object f1615c;

    /* renamed from: d */
    final /* synthetic */ C0490c f1616d;

    public RunnableC0500g(C0490c c0490c, int i, Object obj, Object obj2) {
        this.f1616d = c0490c;
        this.f1613a = i;
        this.f1614b = obj;
        this.f1615c = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1616d.m2492b(this.f1613a, this.f1614b, this.f1615c);
    }
}
