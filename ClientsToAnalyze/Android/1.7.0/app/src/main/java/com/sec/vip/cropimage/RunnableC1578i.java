package com.sec.vip.cropimage;

import android.graphics.Bitmap;
import java.util.concurrent.CountDownLatch;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.i */
/* loaded from: classes.dex */
class RunnableC1578i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ImageModify f5559a;

    RunnableC1578i(ImageModify imageModify) {
        this.f5559a = imageModify;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Bitmap unused = this.f5559a.f5468s;
        this.f5559a.f5459j.post(new RunnableC1600q(this, countDownLatch));
        try {
            countDownLatch.await();
            this.f5559a.f5454d.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
