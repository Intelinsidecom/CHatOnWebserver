package com.sec.vip.cropimage;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.b */
/* loaded from: classes.dex */
class RunnableC1563b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC1596m f5496a;

    RunnableC1563b(RunnableC1596m runnableC1596m) {
        this.f5496a = runnableC1596m;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5496a.f5618c.f5467r.f5476a.size() < 1) {
            this.f5496a.m5815a();
        }
        this.f5496a.f5618c.f5467r.invalidate();
        if (this.f5496a.f5618c.f5467r.f5476a.size() == 1) {
            this.f5496a.f5618c.f5452b = (C1598o) this.f5496a.f5618c.f5467r.f5476a.get(0);
            this.f5496a.f5618c.f5452b.m5829a(true);
        }
        this.f5496a.f5618c.f5467r.onLayout(false, 0, 0, this.f5496a.f5618c.f5467r.getMeasuredWidth(), this.f5496a.f5618c.f5467r.getMeasuredHeight());
    }
}
