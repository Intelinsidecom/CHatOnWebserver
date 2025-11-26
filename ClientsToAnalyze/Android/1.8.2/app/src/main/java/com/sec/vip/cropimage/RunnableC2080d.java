package com.sec.vip.cropimage;

import java.util.concurrent.CountDownLatch;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.d */
/* loaded from: classes.dex */
class RunnableC2080d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CountDownLatch f7565a;

    /* renamed from: b */
    final /* synthetic */ RunnableC2079c f7566b;

    RunnableC2080d(RunnableC2079c runnableC2079c, CountDownLatch countDownLatch) {
        this.f7566b = runnableC2079c;
        this.f7565a = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f7566b.f7564a.f7505q.mo7268a() == 1.0f) {
            this.f7566b.f7564a.f7505q.mo7272a(true, true);
        }
        this.f7565a.countDown();
    }
}
