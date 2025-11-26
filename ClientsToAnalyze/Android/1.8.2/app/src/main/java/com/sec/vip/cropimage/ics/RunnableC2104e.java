package com.sec.vip.cropimage.ics;

import java.util.concurrent.CountDownLatch;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.e */
/* loaded from: classes.dex */
class RunnableC2104e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CropImage f7664a;

    RunnableC2104e(CropImage cropImage) {
        this.f7664a = cropImage;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f7664a.f7639f.post(new RunnableC2105f(this, this.f7664a.f7648o, countDownLatch));
        try {
            countDownLatch.await();
            this.f7664a.f7636b.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
