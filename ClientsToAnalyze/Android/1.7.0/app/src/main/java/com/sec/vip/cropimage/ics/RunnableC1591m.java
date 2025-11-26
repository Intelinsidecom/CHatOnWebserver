package com.sec.vip.cropimage.ics;

import com.sec.vip.cropimage.C1598o;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.m */
/* loaded from: classes.dex */
class RunnableC1591m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC1588j f5611a;

    RunnableC1591m(RunnableC1588j runnableC1588j) {
        this.f5611a = runnableC1588j;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5611a.f5608c.f5576n.f5435b.size() < 1) {
            this.f5611a.m5813a();
        }
        this.f5611a.f5608c.f5576n.invalidate();
        if (this.f5611a.f5608c.f5576n.f5435b.size() == 1) {
            this.f5611a.f5608c.f5564a = (C1598o) this.f5611a.f5608c.f5576n.f5435b.get(0);
            this.f5611a.f5608c.f5564a.m5829a(true);
            this.f5611a.f5608c.f5564a.m5823a(this.f5611a.f5608c.f5579q);
            this.f5611a.f5608c.f5564a.m5825a(this.f5611a.f5608c.f5583u, this.f5611a.f5608c.f5580r, this.f5611a.f5608c.f5578p);
        }
        this.f5611a.f5608c.f5576n.onLayout(false, 0, 0, this.f5611a.f5608c.f5576n.getMeasuredWidth(), this.f5611a.f5608c.f5576n.getMeasuredHeight());
        this.f5611a.f5608c.f5561B.setVisibility(8);
    }
}
