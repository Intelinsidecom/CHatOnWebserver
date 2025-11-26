package com.sec.chaton.p025d.p027b;

/* compiled from: AbstractQueryTask.java */
/* renamed from: com.sec.chaton.d.b.g */
/* loaded from: classes.dex */
class RunnableC0644g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f2242a;

    /* renamed from: b */
    final /* synthetic */ Object f2243b;

    /* renamed from: c */
    final /* synthetic */ AbstractC0647j f2244c;

    RunnableC0644g(AbstractC0647j abstractC0647j, int i, Object obj) {
        this.f2244c = abstractC0647j;
        this.f2242a = i;
        this.f2243b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2244c.f2249a.mo2364a(this.f2242a, false, this.f2243b);
    }
}
