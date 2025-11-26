package com.sec.vip.cropimage;

import java.util.concurrent.CountDownLatch;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.f */
/* loaded from: classes.dex */
class RunnableC5119f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ImageModify f18689a;

    RunnableC5119f(ImageModify imageModify) {
        this.f18689a = imageModify;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f18689a.f18636v.post(new RunnableC5120g(this, countDownLatch));
        try {
            countDownLatch.await();
            this.f18689a.f18632q.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
