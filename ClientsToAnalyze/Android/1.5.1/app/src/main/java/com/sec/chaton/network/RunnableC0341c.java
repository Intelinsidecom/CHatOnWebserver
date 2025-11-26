package com.sec.chaton.network;

/* renamed from: com.sec.chaton.network.c */
/* loaded from: classes.dex */
class RunnableC0341c implements Runnable {

    /* renamed from: a */
    final int f2504a;

    /* renamed from: b */
    final Object f2505b;

    /* renamed from: c */
    final Object f2506c;

    /* renamed from: d */
    final /* synthetic */ NetResultReceiver f2507d;

    public RunnableC0341c(NetResultReceiver netResultReceiver, int i, Object obj, Object obj2) {
        this.f2507d = netResultReceiver;
        this.f2504a = i;
        this.f2505b = obj;
        this.f2506c = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2507d.m2752b(this.f2504a, this.f2505b, this.f2506c);
    }
}
