package com.sec.vip.cropimage;

import java.util.concurrent.CountDownLatch;

/* renamed from: com.sec.vip.cropimage.ab */
/* loaded from: classes.dex */
class RunnableC0726ab implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CountDownLatch f4448a;

    /* renamed from: b */
    final /* synthetic */ RunnableC0735h f4449b;

    RunnableC0726ab(RunnableC0735h runnableC0735h, CountDownLatch countDownLatch) {
        this.f4449b = runnableC0735h;
        this.f4448a = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4449b.f4474a.f4413o.m4325b() == 1.0f) {
            this.f4449b.f4474a.f4413o.m4324a(true, true);
        }
        this.f4448a.countDown();
    }
}
