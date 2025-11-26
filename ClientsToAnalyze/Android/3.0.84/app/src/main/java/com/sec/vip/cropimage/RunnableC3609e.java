package com.sec.vip.cropimage;

import android.graphics.Bitmap;
import java.util.concurrent.CountDownLatch;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.e */
/* loaded from: classes.dex */
class RunnableC3609e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Bitmap f13277a;

    /* renamed from: b */
    final /* synthetic */ CountDownLatch f13278b;

    /* renamed from: c */
    final /* synthetic */ RunnableC3608d f13279c;

    RunnableC3609e(RunnableC3608d runnableC3608d, Bitmap bitmap, CountDownLatch countDownLatch) {
        this.f13279c = runnableC3608d;
        this.f13277a = bitmap;
        this.f13278b = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f13277a != this.f13279c.f13276a.f13176o && this.f13277a != null) {
            this.f13279c.f13276a.f13165c.setImageBitmapResetBase(this.f13277a, (int) this.f13279c.f13276a.f13180s, true);
            this.f13279c.f13276a.f13176o.recycle();
            this.f13279c.f13276a.f13176o = this.f13277a;
        }
        if (this.f13279c.f13276a.f13165c.mo12922a() == 1.0f) {
            this.f13279c.f13276a.f13165c.mo12926a(true, true);
        }
        this.f13278b.countDown();
    }
}
