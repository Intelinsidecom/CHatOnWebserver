package com.sec.vip.cropimage.honeycomb;

import com.sec.vip.cropimage.C1598o;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.honeycomb.b */
/* loaded from: classes.dex */
class RunnableC1571b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC1572c f5545a;

    RunnableC1571b(RunnableC1572c runnableC1572c) {
        this.f5545a = runnableC1572c;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5545a.f5548c.f5529n.f5435b.size() < 1) {
            this.f5545a.m5770a();
        }
        this.f5545a.f5548c.f5529n.invalidate();
        if (this.f5545a.f5548c.f5529n.f5435b.size() == 1) {
            this.f5545a.f5548c.f5517a = (C1598o) this.f5545a.f5548c.f5529n.f5435b.get(0);
            this.f5545a.f5548c.f5517a.m5829a(true);
            this.f5545a.f5548c.f5517a.m5823a(this.f5545a.f5548c.f5532q);
            this.f5545a.f5548c.f5517a.m5825a(this.f5545a.f5548c.f5536u, this.f5545a.f5548c.f5533r, this.f5545a.f5548c.f5531p);
        }
        this.f5545a.f5548c.f5529n.onLayout(false, 0, 0, this.f5545a.f5548c.f5529n.getMeasuredWidth(), this.f5545a.f5548c.f5529n.getMeasuredHeight());
    }
}
