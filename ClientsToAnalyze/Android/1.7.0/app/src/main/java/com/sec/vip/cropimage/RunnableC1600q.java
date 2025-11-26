package com.sec.vip.cropimage;

import java.util.concurrent.CountDownLatch;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.q */
/* loaded from: classes.dex */
class RunnableC1600q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CountDownLatch f5648a;

    /* renamed from: b */
    final /* synthetic */ RunnableC1578i f5649b;

    RunnableC1600q(RunnableC1578i runnableC1578i, CountDownLatch countDownLatch) {
        this.f5649b = runnableC1578i;
        this.f5648a = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5649b.f5559a.f5467r.mo5674a() == 1.0f) {
            this.f5649b.f5559a.f5467r.mo5678a(true, true);
        }
        this.f5648a.countDown();
    }
}
