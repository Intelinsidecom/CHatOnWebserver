package com.sec.vip.cropimage.honeycomb;

import android.graphics.Bitmap;
import java.util.concurrent.CountDownLatch;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.honeycomb.b */
/* loaded from: classes.dex */
class RunnableC2086b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Bitmap f7604a;

    /* renamed from: b */
    final /* synthetic */ CountDownLatch f7605b;

    /* renamed from: c */
    final /* synthetic */ RunnableC2085a f7606c;

    RunnableC2086b(RunnableC2085a runnableC2085a, Bitmap bitmap, CountDownLatch countDownLatch) {
        this.f7606c = runnableC2085a;
        this.f7604a = bitmap;
        this.f7605b = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f7604a != this.f7606c.f7603a.f7592p && this.f7604a != null) {
            this.f7606c.f7603a.f7591o.setImageBitmapResetBase(this.f7604a, (int) this.f7606c.f7603a.f7593q, true);
            this.f7606c.f7603a.f7592p.recycle();
            this.f7606c.f7603a.f7592p = this.f7604a;
        }
        if (this.f7606c.f7603a.f7591o.mo7268a() == 1.0f) {
            this.f7606c.f7603a.f7591o.mo7272a(true, true);
        }
        this.f7605b.countDown();
    }
}
