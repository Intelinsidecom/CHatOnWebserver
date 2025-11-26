package com.sec.vip.cropimage;

/* compiled from: ImageViewTouchBase.java */
/* renamed from: com.sec.vip.cropimage.s */
/* loaded from: classes.dex */
class RunnableC5132s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ float f18714a;

    /* renamed from: b */
    final /* synthetic */ long f18715b;

    /* renamed from: c */
    final /* synthetic */ float f18716c;

    /* renamed from: d */
    final /* synthetic */ float f18717d;

    /* renamed from: e */
    final /* synthetic */ float f18718e;

    /* renamed from: f */
    final /* synthetic */ float f18719f;

    /* renamed from: g */
    final /* synthetic */ ImageViewTouchBase f18720g;

    RunnableC5132s(ImageViewTouchBase imageViewTouchBase, float f, long j, float f2, float f3, float f4, float f5) {
        this.f18720g = imageViewTouchBase;
        this.f18714a = f;
        this.f18715b = j;
        this.f18716c = f2;
        this.f18717d = f3;
        this.f18718e = f4;
        this.f18719f = f5;
    }

    @Override // java.lang.Runnable
    public void run() {
        float fMin = Math.min(this.f18714a, System.currentTimeMillis() - this.f18715b);
        this.f18720g.mo19550a(this.f18716c + (this.f18717d * fMin), this.f18718e, this.f18719f);
        if (fMin < this.f18714a) {
            this.f18720g.f18657n.post(this);
        }
    }
}
