package com.sec.chaton.p027e.p029b;

/* compiled from: AbstractQueryTask.java */
/* renamed from: com.sec.chaton.e.b.b */
/* loaded from: classes.dex */
class RunnableC1411b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f5244a;

    /* renamed from: b */
    final /* synthetic */ Object f5245b;

    /* renamed from: c */
    final /* synthetic */ AbstractC1410a f5246c;

    RunnableC1411b(AbstractC1410a abstractC1410a, int i, Object obj) {
        this.f5246c = abstractC1410a;
        this.f5244a = i;
        this.f5245b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5246c.f5243c.mo4048a(this.f5244a, this.f5246c.f5242b, this.f5245b);
    }
}
