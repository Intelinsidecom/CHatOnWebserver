package com.sec.vip.cropimage;

/* compiled from: ImageViewTouchBase.java */
/* renamed from: com.sec.vip.cropimage.af */
/* loaded from: classes.dex */
class RunnableC3600af implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3605ak f13262a;

    /* renamed from: b */
    final /* synthetic */ boolean f13263b;

    /* renamed from: c */
    final /* synthetic */ ImageViewTouchBase f13264c;

    RunnableC3600af(ImageViewTouchBase imageViewTouchBase, C3605ak c3605ak, boolean z) {
        this.f13264c = imageViewTouchBase;
        this.f13262a = c3605ak;
        this.f13263b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13264c.setImageRotateBitmapResetBase(this.f13262a, this.f13263b);
    }
}
