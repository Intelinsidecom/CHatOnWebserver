package com.sec.chaton.p027e.p029b;

/* compiled from: AbstractQueryTask.java */
/* renamed from: com.sec.chaton.e.b.c */
/* loaded from: classes.dex */
class RunnableC1412c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f5247a;

    /* renamed from: b */
    final /* synthetic */ Object f5248b;

    /* renamed from: c */
    final /* synthetic */ AbstractC1410a f5249c;

    RunnableC1412c(AbstractC1410a abstractC1410a, int i, Object obj) {
        this.f5249c = abstractC1410a;
        this.f5247a = i;
        this.f5248b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5249c.f5243c.mo4048a(this.f5247a, false, this.f5248b);
    }
}
