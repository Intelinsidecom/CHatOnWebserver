package com.sec.vip.cropimage.ics;

import java.util.concurrent.CountDownLatch;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.k */
/* loaded from: classes.dex */
class RunnableC1589k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CropImage f5609a;

    RunnableC1589k(CropImage cropImage) {
        this.f5609a = cropImage;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f5609a.f5568f.post(new RunnableC1581c(this, this.f5609a.f5577o, countDownLatch));
        try {
            countDownLatch.await();
            this.f5609a.f5565b.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
