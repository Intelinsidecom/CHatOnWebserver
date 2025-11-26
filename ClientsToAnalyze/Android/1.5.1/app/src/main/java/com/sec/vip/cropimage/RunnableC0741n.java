package com.sec.vip.cropimage;

import android.graphics.Bitmap;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.sec.vip.cropimage.n */
/* loaded from: classes.dex */
class RunnableC0741n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Bitmap f4483a;

    /* renamed from: b */
    final /* synthetic */ CountDownLatch f4484b;

    /* renamed from: c */
    final /* synthetic */ RunnableC0750w f4485c;

    RunnableC0741n(RunnableC0750w runnableC0750w, Bitmap bitmap, CountDownLatch countDownLatch) {
        this.f4485c = runnableC0750w;
        this.f4483a = bitmap;
        this.f4484b = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4483a != this.f4485c.f4519a.f4376o && this.f4483a != null) {
            this.f4485c.f4519a.f4375n.m4322a(this.f4483a, (int) this.f4485c.f4519a.f4377p, true);
            this.f4485c.f4519a.f4376o.recycle();
            this.f4485c.f4519a.f4376o = this.f4483a;
        }
        if (this.f4485c.f4519a.f4375n.m4325b() == 1.0f) {
            this.f4485c.f4519a.f4375n.m4324a(true, true);
        }
        this.f4484b.countDown();
    }
}
