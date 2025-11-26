package com.sec.chaton.p057e.p059b;

/* compiled from: AbstractQueryTask.java */
/* renamed from: com.sec.chaton.e.b.c */
/* loaded from: classes.dex */
class RunnableC2242c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f7987a;

    /* renamed from: b */
    final /* synthetic */ Object f7988b;

    /* renamed from: c */
    final /* synthetic */ AbstractC2240a f7989c;

    RunnableC2242c(AbstractC2240a abstractC2240a, int i, Object obj) {
        this.f7989c = abstractC2240a;
        this.f7987a = i;
        this.f7988b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7989c.f7983c.mo7130a(this.f7987a, false, this.f7988b);
    }
}
