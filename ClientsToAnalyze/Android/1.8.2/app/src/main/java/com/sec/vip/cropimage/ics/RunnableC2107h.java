package com.sec.vip.cropimage.ics;

import com.sec.vip.cropimage.C2077a;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.h */
/* loaded from: classes.dex */
class RunnableC2107h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC2106g f7671a;

    RunnableC2107h(RunnableC2106g runnableC2106g) {
        this.f7671a = runnableC2106g;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f7671a.f7670c.f7647n.f7478b.size() < 1) {
            this.f7671a.m7424a();
        }
        this.f7671a.f7670c.f7647n.invalidate();
        if (this.f7671a.f7670c.f7647n.f7478b.size() == 1) {
            this.f7671a.f7670c.f7635a = (C2077a) this.f7671a.f7670c.f7647n.f7478b.get(0);
            this.f7671a.f7670c.f7635a.m7330a(true);
            this.f7671a.f7670c.f7635a.m7324a(this.f7671a.f7670c.f7650q);
            this.f7671a.f7670c.f7635a.m7326a(this.f7671a.f7670c.f7654u, this.f7671a.f7670c.f7651r, this.f7671a.f7670c.f7649p);
        }
        this.f7671a.f7670c.f7647n.onLayout(false, 0, 0, this.f7671a.f7670c.f7647n.getMeasuredWidth(), this.f7671a.f7670c.f7647n.getMeasuredHeight());
        this.f7671a.f7670c.f7632B.setVisibility(8);
    }
}
