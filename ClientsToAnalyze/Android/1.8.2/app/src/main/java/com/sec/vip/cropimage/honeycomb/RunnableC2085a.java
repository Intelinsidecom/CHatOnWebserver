package com.sec.vip.cropimage.honeycomb;

import java.util.concurrent.CountDownLatch;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.honeycomb.a */
/* loaded from: classes.dex */
class RunnableC2085a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CropImage f7603a;

    RunnableC2085a(CropImage cropImage) {
        this.f7603a = cropImage;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f7603a.f7583g.post(new RunnableC2086b(this, this.f7603a.f7592p, countDownLatch));
        try {
            countDownLatch.await();
            this.f7603a.f7580c.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
