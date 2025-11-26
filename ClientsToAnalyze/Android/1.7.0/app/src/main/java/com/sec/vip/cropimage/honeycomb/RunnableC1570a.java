package com.sec.vip.cropimage.honeycomb;

import android.graphics.Bitmap;
import java.util.concurrent.CountDownLatch;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.honeycomb.a */
/* loaded from: classes.dex */
class RunnableC1570a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Bitmap f5542a;

    /* renamed from: b */
    final /* synthetic */ CountDownLatch f5543b;

    /* renamed from: c */
    final /* synthetic */ RunnableC1575f f5544c;

    RunnableC1570a(RunnableC1575f runnableC1575f, Bitmap bitmap, CountDownLatch countDownLatch) {
        this.f5544c = runnableC1575f;
        this.f5542a = bitmap;
        this.f5543b = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5542a != this.f5544c.f5552a.f5530o && this.f5542a != null) {
            this.f5544c.f5552a.f5529n.setImageBitmapResetBase(this.f5542a, (int) this.f5544c.f5552a.f5531p, true);
            this.f5544c.f5552a.f5530o.recycle();
            this.f5544c.f5552a.f5530o = this.f5542a;
        }
        if (this.f5544c.f5552a.f5529n.mo5674a() == 1.0f) {
            this.f5544c.f5552a.f5529n.mo5678a(true, true);
        }
        this.f5543b.countDown();
    }
}
