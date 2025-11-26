package com.sec.vip.cropimage;

/* compiled from: ImageViewTouchBase.java */
/* renamed from: com.sec.vip.cropimage.k */
/* loaded from: classes.dex */
class RunnableC2114k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2119p f7684a;

    /* renamed from: b */
    final /* synthetic */ boolean f7685b;

    /* renamed from: c */
    final /* synthetic */ ImageViewTouchBase f7686c;

    RunnableC2114k(ImageViewTouchBase imageViewTouchBase, C2119p c2119p, boolean z) {
        this.f7686c = imageViewTouchBase;
        this.f7684a = c2119p;
        this.f7685b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7686c.setImageRotateBitmapResetBase(this.f7684a, this.f7685b);
    }
}
