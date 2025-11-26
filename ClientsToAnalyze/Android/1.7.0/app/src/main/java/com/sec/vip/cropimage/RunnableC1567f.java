package com.sec.vip.cropimage;

/* compiled from: ImageViewTouchBase.java */
/* renamed from: com.sec.vip.cropimage.f */
/* loaded from: classes.dex */
class RunnableC1567f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1565d f5503a;

    /* renamed from: b */
    final /* synthetic */ boolean f5504b;

    /* renamed from: c */
    final /* synthetic */ ImageViewTouchBase f5505c;

    RunnableC1567f(ImageViewTouchBase imageViewTouchBase, C1565d c1565d, boolean z) {
        this.f5505c = imageViewTouchBase;
        this.f5503a = c1565d;
        this.f5504b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5505c.setImageRotateBitmapResetBase(this.f5503a, this.f5504b);
    }
}
