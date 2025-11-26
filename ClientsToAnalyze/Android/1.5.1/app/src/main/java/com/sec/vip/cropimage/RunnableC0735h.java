package com.sec.vip.cropimage;

import android.graphics.Bitmap;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.sec.vip.cropimage.h */
/* loaded from: classes.dex */
class RunnableC0735h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ImageModify f4474a;

    RunnableC0735h(ImageModify imageModify) {
        this.f4474a = imageModify;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Bitmap unused = this.f4474a.f4414p;
        this.f4474a.f4405g.post(new RunnableC0726ab(this, countDownLatch));
        try {
            countDownLatch.await();
            this.f4474a.f4402d.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
