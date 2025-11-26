package com.sec.vip.cropimage;

import java.util.concurrent.CountDownLatch;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.u */
/* loaded from: classes.dex */
class RunnableC3625u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CountDownLatch f13332a;

    /* renamed from: b */
    final /* synthetic */ RunnableC3624t f13333b;

    RunnableC3625u(RunnableC3624t runnableC3624t, CountDownLatch countDownLatch) {
        this.f13333b = runnableC3624t;
        this.f13332a = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f13333b.f13331a.f13221s.mo12922a() == 1.0f) {
            this.f13333b.f13331a.f13221s.mo12926a(true, true);
        }
        this.f13332a.countDown();
    }
}
