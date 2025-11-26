package com.sec.vip.cropimage;

/* renamed from: com.sec.vip.cropimage.d */
/* loaded from: classes.dex */
class RunnableC0731d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ float f4463a;

    /* renamed from: b */
    final /* synthetic */ long f4464b;

    /* renamed from: c */
    final /* synthetic */ float f4465c;

    /* renamed from: d */
    final /* synthetic */ float f4466d;

    /* renamed from: e */
    final /* synthetic */ float f4467e;

    /* renamed from: f */
    final /* synthetic */ float f4468f;

    /* renamed from: g */
    final /* synthetic */ ImageViewTouchBase f4469g;

    RunnableC0731d(ImageViewTouchBase imageViewTouchBase, float f, long j, float f2, float f3, float f4, float f5) {
        this.f4469g = imageViewTouchBase;
        this.f4463a = f;
        this.f4464b = j;
        this.f4465c = f2;
        this.f4466d = f3;
        this.f4467e = f4;
        this.f4468f = f5;
    }

    @Override // java.lang.Runnable
    public void run() {
        float fMin = Math.min(this.f4463a, System.currentTimeMillis() - this.f4464b);
        this.f4469g.mo4278a(this.f4465c + (this.f4466d * fMin), this.f4467e, this.f4468f);
        if (fMin < this.f4463a) {
            this.f4469g.f4442n.post(this);
        }
    }
}
