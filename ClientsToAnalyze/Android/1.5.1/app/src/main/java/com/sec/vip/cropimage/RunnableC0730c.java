package com.sec.vip.cropimage;

/* renamed from: com.sec.vip.cropimage.c */
/* loaded from: classes.dex */
class RunnableC0730c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RotateBitmap f4460a;

    /* renamed from: b */
    final /* synthetic */ boolean f4461b;

    /* renamed from: c */
    final /* synthetic */ ImageViewTouchBase f4462c;

    RunnableC0730c(ImageViewTouchBase imageViewTouchBase, RotateBitmap rotateBitmap, boolean z) {
        this.f4462c = imageViewTouchBase;
        this.f4460a = rotateBitmap;
        this.f4461b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4462c.m4323a(this.f4460a, this.f4461b);
    }
}
