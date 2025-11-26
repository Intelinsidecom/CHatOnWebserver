package com.sec.chaton.push.network;

/* renamed from: com.sec.chaton.push.network.b */
/* loaded from: classes.dex */
class RunnableC0393b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f2740a;

    /* renamed from: b */
    final /* synthetic */ MessageContext f2741b;

    RunnableC0393b(MessageContext messageContext, int i) {
        this.f2741b = messageContext;
        this.f2740a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2741b.f2735b.mo2959a(this.f2740a, this.f2741b.f2734a);
    }
}
