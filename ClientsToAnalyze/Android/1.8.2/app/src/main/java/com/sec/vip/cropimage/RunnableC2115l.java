package com.sec.vip.cropimage;

/* compiled from: ImageViewTouchBase.java */
/* renamed from: com.sec.vip.cropimage.l */
/* loaded from: classes.dex */
class RunnableC2115l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ float f7687a;

    /* renamed from: b */
    final /* synthetic */ long f7688b;

    /* renamed from: c */
    final /* synthetic */ float f7689c;

    /* renamed from: d */
    final /* synthetic */ float f7690d;

    /* renamed from: e */
    final /* synthetic */ float f7691e;

    /* renamed from: f */
    final /* synthetic */ float f7692f;

    /* renamed from: g */
    final /* synthetic */ ImageViewTouchBase f7693g;

    RunnableC2115l(ImageViewTouchBase imageViewTouchBase, float f, long j, float f2, float f3, float f4, float f5) {
        this.f7693g = imageViewTouchBase;
        this.f7687a = f;
        this.f7688b = j;
        this.f7689c = f2;
        this.f7690d = f3;
        this.f7691e = f4;
        this.f7692f = f5;
    }

    @Override // java.lang.Runnable
    public void run() {
        float fMin = Math.min(this.f7687a, System.currentTimeMillis() - this.f7688b);
        this.f7693g.mo7270a(this.f7689c + (this.f7690d * fMin), this.f7691e, this.f7692f);
        if (fMin < this.f7687a) {
            this.f7693g.f7532n.post(this);
        }
    }
}
