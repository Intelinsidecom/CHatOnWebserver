package com.sec.vip.cropimage;

import android.graphics.Bitmap;
import java.util.concurrent.CountDownLatch;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.c */
/* loaded from: classes.dex */
class RunnableC2079c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ImageModify f7564a;

    RunnableC2079c(ImageModify imageModify) {
        this.f7564a = imageModify;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Bitmap unused = this.f7564a.f7506r;
        this.f7564a.f7496h.post(new RunnableC2080d(this, countDownLatch));
        try {
            countDownLatch.await();
            this.f7564a.f7493d.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
