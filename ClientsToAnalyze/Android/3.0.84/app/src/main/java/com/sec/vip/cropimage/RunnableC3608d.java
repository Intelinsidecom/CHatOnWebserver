package com.sec.vip.cropimage;

import java.util.concurrent.CountDownLatch;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.d */
/* loaded from: classes.dex */
class RunnableC3608d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CropImage f13276a;

    RunnableC3608d(CropImage cropImage) {
        this.f13276a = cropImage;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f13276a.f13168g.post(new RunnableC3609e(this, this.f13276a.f13176o, countDownLatch));
        try {
            countDownLatch.await();
            this.f13276a.f13164b.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
