package com.sec.vip.cropimage;

/* compiled from: ImageViewTouchBase.java */
/* renamed from: com.sec.vip.cropimage.g */
/* loaded from: classes.dex */
class RunnableC1568g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ float f5506a;

    /* renamed from: b */
    final /* synthetic */ long f5507b;

    /* renamed from: c */
    final /* synthetic */ float f5508c;

    /* renamed from: d */
    final /* synthetic */ float f5509d;

    /* renamed from: e */
    final /* synthetic */ float f5510e;

    /* renamed from: f */
    final /* synthetic */ float f5511f;

    /* renamed from: g */
    final /* synthetic */ ImageViewTouchBase f5512g;

    RunnableC1568g(ImageViewTouchBase imageViewTouchBase, float f, long j, float f2, float f3, float f4, float f5) {
        this.f5512g = imageViewTouchBase;
        this.f5506a = f;
        this.f5507b = j;
        this.f5508c = f2;
        this.f5509d = f3;
        this.f5510e = f4;
        this.f5511f = f5;
    }

    @Override // java.lang.Runnable
    public void run() {
        float fMin = Math.min(this.f5506a, System.currentTimeMillis() - this.f5507b);
        this.f5512g.mo5676a(this.f5508c + (this.f5509d * fMin), this.f5510e, this.f5511f);
        if (fMin < this.f5506a) {
            this.f5512g.f5493n.post(this);
        }
    }
}
