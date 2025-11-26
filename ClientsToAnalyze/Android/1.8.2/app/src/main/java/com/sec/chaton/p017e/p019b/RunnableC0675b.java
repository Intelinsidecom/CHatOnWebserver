package com.sec.chaton.p017e.p019b;

/* compiled from: AbstractQueryTask.java */
/* renamed from: com.sec.chaton.e.b.b */
/* loaded from: classes.dex */
class RunnableC0675b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f2562a;

    /* renamed from: b */
    final /* synthetic */ Object f2563b;

    /* renamed from: c */
    final /* synthetic */ AbstractC0674a f2564c;

    RunnableC0675b(AbstractC0674a abstractC0674a, int i, Object obj) {
        this.f2564c = abstractC0674a;
        this.f2562a = i;
        this.f2563b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2564c.f2561b.mo2365a(this.f2562a, true, this.f2563b);
    }
}
