package com.sec.vip.cropimage.ics;

import android.graphics.Bitmap;
import java.util.concurrent.CountDownLatch;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.f */
/* loaded from: classes.dex */
class RunnableC2105f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Bitmap f7665a;

    /* renamed from: b */
    final /* synthetic */ CountDownLatch f7666b;

    /* renamed from: c */
    final /* synthetic */ RunnableC2104e f7667c;

    RunnableC2105f(RunnableC2104e runnableC2104e, Bitmap bitmap, CountDownLatch countDownLatch) {
        this.f7667c = runnableC2104e;
        this.f7665a = bitmap;
        this.f7666b = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f7665a != this.f7667c.f7664a.f7648o && this.f7665a != null) {
            this.f7667c.f7664a.f7647n.setImageBitmapResetBase(this.f7665a, (int) this.f7667c.f7664a.f7649p, true);
            this.f7667c.f7664a.f7648o.recycle();
            this.f7667c.f7664a.f7648o = this.f7665a;
        }
        if (this.f7667c.f7664a.f7647n.mo7268a() == 1.0f) {
            this.f7667c.f7664a.f7647n.mo7272a(true, true);
        }
        this.f7666b.countDown();
    }
}
