package com.sec.vip.cropimage;

/* compiled from: ImageViewTouchBase.java */
/* renamed from: com.sec.vip.cropimage.ag */
/* loaded from: classes.dex */
class RunnableC3601ag implements Runnable {

    /* renamed from: a */
    final /* synthetic */ float f13265a;

    /* renamed from: b */
    final /* synthetic */ long f13266b;

    /* renamed from: c */
    final /* synthetic */ float f13267c;

    /* renamed from: d */
    final /* synthetic */ float f13268d;

    /* renamed from: e */
    final /* synthetic */ float f13269e;

    /* renamed from: f */
    final /* synthetic */ float f13270f;

    /* renamed from: g */
    final /* synthetic */ ImageViewTouchBase f13271g;

    RunnableC3601ag(ImageViewTouchBase imageViewTouchBase, float f, long j, float f2, float f3, float f4, float f5) {
        this.f13271g = imageViewTouchBase;
        this.f13265a = f;
        this.f13266b = j;
        this.f13267c = f2;
        this.f13268d = f3;
        this.f13269e = f4;
        this.f13270f = f5;
    }

    @Override // java.lang.Runnable
    public void run() {
        float fMin = Math.min(this.f13265a, System.currentTimeMillis() - this.f13266b);
        this.f13271g.mo12924a(this.f13267c + (this.f13268d * fMin), this.f13269e, this.f13270f);
        if (fMin < this.f13265a) {
            this.f13271g.f13246n.post(this);
        }
    }
}
