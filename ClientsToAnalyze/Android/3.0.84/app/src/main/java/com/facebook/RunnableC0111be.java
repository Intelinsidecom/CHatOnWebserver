package com.facebook;

/* compiled from: Session.java */
/* renamed from: com.facebook.be */
/* loaded from: classes.dex */
class RunnableC0111be implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InterfaceC0120bn f219a;

    /* renamed from: b */
    final /* synthetic */ RunnableC0110bd f220b;

    RunnableC0111be(RunnableC0110bd runnableC0110bd, InterfaceC0120bn interfaceC0120bn) {
        this.f220b = runnableC0110bd;
        this.f219a = interfaceC0120bn;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f219a.mo263a(this.f220b.f218c, this.f220b.f216a, this.f220b.f217b);
    }
}
