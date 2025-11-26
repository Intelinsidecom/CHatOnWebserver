package com.sec.chaton.network;

/* renamed from: com.sec.chaton.network.a */
/* loaded from: classes.dex */
class RunnableC0339a implements Runnable {

    /* renamed from: a */
    final int f2501a;

    /* renamed from: b */
    final Object f2502b;

    /* renamed from: c */
    final /* synthetic */ NetResultReceiver f2503c;

    public RunnableC0339a(NetResultReceiver netResultReceiver, int i, Object obj) {
        this.f2503c = netResultReceiver;
        this.f2501a = i;
        this.f2502b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2503c.m2751b(this.f2501a, this.f2502b);
    }
}
