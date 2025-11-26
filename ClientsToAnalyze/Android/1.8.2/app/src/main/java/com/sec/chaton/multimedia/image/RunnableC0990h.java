package com.sec.chaton.multimedia.image;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.chaton.multimedia.image.h */
/* loaded from: classes.dex */
class RunnableC0990h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ float f3650a;

    /* renamed from: b */
    final /* synthetic */ long f3651b;

    /* renamed from: c */
    final /* synthetic */ float f3652c;

    /* renamed from: d */
    final /* synthetic */ float f3653d;

    /* renamed from: e */
    final /* synthetic */ float f3654e;

    /* renamed from: f */
    final /* synthetic */ float f3655f;

    /* renamed from: g */
    final /* synthetic */ ZoomableImageView f3656g;

    RunnableC0990h(ZoomableImageView zoomableImageView, float f, long j, float f2, float f3, float f4, float f5) {
        this.f3656g = zoomableImageView;
        this.f3650a = f;
        this.f3651b = j;
        this.f3652c = f2;
        this.f3653d = f3;
        this.f3654e = f4;
        this.f3655f = f5;
    }

    @Override // java.lang.Runnable
    public void run() {
        float fMin = Math.min(this.f3650a, System.currentTimeMillis() - this.f3651b);
        this.f3656g.m3881a(this.f3652c + (this.f3653d * fMin), this.f3654e, this.f3655f);
        if (fMin < this.f3650a) {
            this.f3656g.post(this);
        }
    }
}
