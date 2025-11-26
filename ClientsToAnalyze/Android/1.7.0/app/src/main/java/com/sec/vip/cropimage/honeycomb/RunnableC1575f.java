package com.sec.vip.cropimage.honeycomb;

import java.util.concurrent.CountDownLatch;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.honeycomb.f */
/* loaded from: classes.dex */
class RunnableC1575f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CropImage f5552a;

    RunnableC1575f(CropImage cropImage) {
        this.f5552a = cropImage;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f5552a.f5521f.post(new RunnableC1570a(this, this.f5552a.f5530o, countDownLatch));
        try {
            countDownLatch.await();
            this.f5552a.f5518b.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
