package com.sec.vip.cropimage;

/* compiled from: ImageViewTouchBase.java */
/* renamed from: com.sec.vip.cropimage.r */
/* loaded from: classes.dex */
class RunnableC5131r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C5135v f18711a;

    /* renamed from: b */
    final /* synthetic */ boolean f18712b;

    /* renamed from: c */
    final /* synthetic */ ImageViewTouchBase f18713c;

    RunnableC5131r(ImageViewTouchBase imageViewTouchBase, C5135v c5135v, boolean z) {
        this.f18713c = imageViewTouchBase;
        this.f18711a = c5135v;
        this.f18712b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18713c.m19560a(this.f18711a, this.f18712b);
    }
}
