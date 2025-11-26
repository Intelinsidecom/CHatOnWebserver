package com.sec.vip.cropimage.ics;

import android.graphics.Bitmap;
import java.util.concurrent.CountDownLatch;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.c */
/* loaded from: classes.dex */
class RunnableC1581c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Bitmap f5596a;

    /* renamed from: b */
    final /* synthetic */ CountDownLatch f5597b;

    /* renamed from: c */
    final /* synthetic */ RunnableC1589k f5598c;

    RunnableC1581c(RunnableC1589k runnableC1589k, Bitmap bitmap, CountDownLatch countDownLatch) {
        this.f5598c = runnableC1589k;
        this.f5596a = bitmap;
        this.f5597b = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5596a != this.f5598c.f5609a.f5577o && this.f5596a != null) {
            this.f5598c.f5609a.f5576n.setImageBitmapResetBase(this.f5596a, (int) this.f5598c.f5609a.f5578p, true);
            this.f5598c.f5609a.f5577o.recycle();
            this.f5598c.f5609a.f5577o = this.f5596a;
        }
        if (this.f5598c.f5609a.f5576n.mo5674a() == 1.0f) {
            this.f5598c.f5609a.f5576n.mo5678a(true, true);
        }
        this.f5597b.countDown();
    }
}
