package com.sec.chaton.p037j;

/* compiled from: NetResultReceiver.java */
/* renamed from: com.sec.chaton.j.r */
/* loaded from: classes.dex */
class RunnableC1590r implements Runnable {

    /* renamed from: a */
    final int f5904a;

    /* renamed from: b */
    final Object f5905b;

    /* renamed from: c */
    final /* synthetic */ C1589q f5906c;

    public RunnableC1590r(C1589q c1589q, int i, Object obj) {
        this.f5906c = c1589q;
        this.f5904a = i;
        this.f5905b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5906c.m6731b(this.f5904a, this.f5905b);
    }
}
