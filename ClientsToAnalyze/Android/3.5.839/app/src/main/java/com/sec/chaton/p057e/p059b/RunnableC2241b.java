package com.sec.chaton.p057e.p059b;

/* compiled from: AbstractQueryTask.java */
/* renamed from: com.sec.chaton.e.b.b */
/* loaded from: classes.dex */
class RunnableC2241b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f7984a;

    /* renamed from: b */
    final /* synthetic */ Object f7985b;

    /* renamed from: c */
    final /* synthetic */ AbstractC2240a f7986c;

    RunnableC2241b(AbstractC2240a abstractC2240a, int i, Object obj) {
        this.f7986c = abstractC2240a;
        this.f7984a = i;
        this.f7985b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7986c.f7983c.mo7130a(this.f7984a, this.f7986c.f7982b, this.f7985b);
    }
}
