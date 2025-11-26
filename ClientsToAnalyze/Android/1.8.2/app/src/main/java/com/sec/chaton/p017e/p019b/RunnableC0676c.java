package com.sec.chaton.p017e.p019b;

/* compiled from: AbstractQueryTask.java */
/* renamed from: com.sec.chaton.e.b.c */
/* loaded from: classes.dex */
class RunnableC0676c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f2565a;

    /* renamed from: b */
    final /* synthetic */ Object f2566b;

    /* renamed from: c */
    final /* synthetic */ AbstractC0674a f2567c;

    RunnableC0676c(AbstractC0674a abstractC0674a, int i, Object obj) {
        this.f2567c = abstractC0674a;
        this.f2565a = i;
        this.f2566b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2567c.f2561b.mo2365a(this.f2565a, false, this.f2566b);
    }
}
