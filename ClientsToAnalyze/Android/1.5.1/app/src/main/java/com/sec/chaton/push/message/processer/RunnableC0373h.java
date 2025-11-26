package com.sec.chaton.push.message.processer;

/* renamed from: com.sec.chaton.push.message.processer.h */
/* loaded from: classes.dex */
class RunnableC0373h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0377l f2693a;

    RunnableC0373h(C0377l c0377l) {
        this.f2693a = c0377l;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2693a.f2703b.f2623b.m2931d() || this.f2693a.f2703b.f2623b.m2930c()) {
            return;
        }
        this.f2693a.f2703b.f2623b.m2928b(this.f2693a.f2702a, (ICallback) null);
    }
}
