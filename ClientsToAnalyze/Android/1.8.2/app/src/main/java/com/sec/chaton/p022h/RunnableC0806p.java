package com.sec.chaton.p022h;

/* compiled from: NetResultReceiver.java */
/* renamed from: com.sec.chaton.h.p */
/* loaded from: classes.dex */
class RunnableC0806p implements Runnable {

    /* renamed from: a */
    final int f2966a;

    /* renamed from: b */
    final Object f2967b;

    /* renamed from: c */
    final /* synthetic */ C0805o f2968c;

    public RunnableC0806p(C0805o c0805o, int i, Object obj) {
        this.f2968c = c0805o;
        this.f2966a = i;
        this.f2967b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2968c.m3418b(this.f2966a, this.f2967b);
    }
}
