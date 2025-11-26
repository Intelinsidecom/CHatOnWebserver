package com.sec.chaton.database.task;

/* renamed from: com.sec.chaton.database.task.b */
/* loaded from: classes.dex */
class RunnableC0216b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f1819a;

    /* renamed from: b */
    final /* synthetic */ Object f1820b;

    /* renamed from: c */
    final /* synthetic */ AbstractQueryTask f1821c;

    RunnableC0216b(AbstractQueryTask abstractQueryTask, int i, Object obj) {
        this.f1821c = abstractQueryTask;
        this.f1819a = i;
        this.f1820b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1821c.f1781a.mo654a(this.f1819a, true, this.f1820b);
    }
}
