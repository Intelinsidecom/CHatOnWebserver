package com.sec.vip.cropimage.honeycomb;

import com.sec.vip.cropimage.C2077a;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.honeycomb.e */
/* loaded from: classes.dex */
class RunnableC2089e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC2088d f7611a;

    RunnableC2089e(RunnableC2088d runnableC2088d) {
        this.f7611a = runnableC2088d;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f7611a.f7610c.f7591o.f7478b.size() < 1) {
            this.f7611a.m7379a();
        }
        this.f7611a.f7610c.f7591o.invalidate();
        if (this.f7611a.f7610c.f7591o.f7478b.size() == 1) {
            this.f7611a.f7610c.f7578a = (C2077a) this.f7611a.f7610c.f7591o.f7478b.get(0);
            this.f7611a.f7610c.f7578a.m7330a(true);
            this.f7611a.f7610c.f7578a.m7324a(this.f7611a.f7610c.f7594r);
            this.f7611a.f7610c.f7578a.m7326a(this.f7611a.f7610c.f7598v, this.f7611a.f7610c.f7595s, this.f7611a.f7610c.f7593q);
        }
        this.f7611a.f7610c.f7591o.onLayout(false, 0, 0, this.f7611a.f7610c.f7591o.getMeasuredWidth(), this.f7611a.f7610c.f7591o.getMeasuredHeight());
    }
}
