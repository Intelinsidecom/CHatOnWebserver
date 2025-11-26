package com.sec.vip.cropimage;

import java.util.concurrent.CountDownLatch;

/* renamed from: com.sec.vip.cropimage.w */
/* loaded from: classes.dex */
class RunnableC0750w implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CropImage f4519a;

    RunnableC0750w(CropImage cropImage) {
        this.f4519a = cropImage;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f4519a.f4367f.post(new RunnableC0741n(this, this.f4519a.f4376o, countDownLatch));
        try {
            countDownLatch.await();
            this.f4519a.f4364c.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
