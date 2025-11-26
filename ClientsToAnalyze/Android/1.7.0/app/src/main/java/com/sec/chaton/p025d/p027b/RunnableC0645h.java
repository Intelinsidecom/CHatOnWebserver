package com.sec.chaton.p025d.p027b;

/* compiled from: AbstractQueryTask.java */
/* renamed from: com.sec.chaton.d.b.h */
/* loaded from: classes.dex */
class RunnableC0645h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f2245a;

    /* renamed from: b */
    final /* synthetic */ Object f2246b;

    /* renamed from: c */
    final /* synthetic */ AbstractC0647j f2247c;

    RunnableC0645h(AbstractC0647j abstractC0647j, int i, Object obj) {
        this.f2247c = abstractC0647j;
        this.f2245a = i;
        this.f2246b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2247c.f2249a.mo2364a(this.f2245a, true, this.f2246b);
    }
}
