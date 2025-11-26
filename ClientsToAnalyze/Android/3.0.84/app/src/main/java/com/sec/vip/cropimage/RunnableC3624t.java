package com.sec.vip.cropimage;

import java.util.concurrent.CountDownLatch;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.t */
/* loaded from: classes.dex */
class RunnableC3624t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ImageModify f13331a;

    RunnableC3624t(ImageModify imageModify) {
        this.f13331a = imageModify;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f13331a.f13212j.post(new RunnableC3625u(this, countDownLatch));
        try {
            countDownLatch.await();
            this.f13331a.f13208d.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
