package com.sec.vip.cropimage;

import java.util.concurrent.CountDownLatch;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.g */
/* loaded from: classes.dex */
class RunnableC5120g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CountDownLatch f18690a;

    /* renamed from: b */
    final /* synthetic */ RunnableC5119f f18691b;

    RunnableC5120g(RunnableC5119f runnableC5119f, CountDownLatch countDownLatch) {
        this.f18691b = runnableC5119f;
        this.f18690a = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f18691b.f18689a.f18612E.m19562b() == 1.0f) {
            this.f18691b.f18689a.f18612E.m19561a(true, true);
        }
        this.f18690a.countDown();
    }
}
