package com.sec.chaton.database.task;

/* renamed from: com.sec.chaton.database.task.a */
/* loaded from: classes.dex */
class RunnableC0215a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f1816a;

    /* renamed from: b */
    final /* synthetic */ Object f1817b;

    /* renamed from: c */
    final /* synthetic */ AbstractQueryTask f1818c;

    RunnableC0215a(AbstractQueryTask abstractQueryTask, int i, Object obj) {
        this.f1818c = abstractQueryTask;
        this.f1816a = i;
        this.f1817b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1818c.f1781a.mo654a(this.f1816a, false, this.f1817b);
    }
}
