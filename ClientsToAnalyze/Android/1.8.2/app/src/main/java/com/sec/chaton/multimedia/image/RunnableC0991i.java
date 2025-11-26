package com.sec.chaton.multimedia.image;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.chaton.multimedia.image.i */
/* loaded from: classes.dex */
class RunnableC0991i implements Runnable {

    /* renamed from: a */
    float f3657a = 0.0f;

    /* renamed from: b */
    float f3658b = 0.0f;

    /* renamed from: c */
    final /* synthetic */ float f3659c;

    /* renamed from: d */
    final /* synthetic */ long f3660d;

    /* renamed from: e */
    final /* synthetic */ float f3661e;

    /* renamed from: f */
    final /* synthetic */ float f3662f;

    /* renamed from: g */
    final /* synthetic */ ZoomableImageView f3663g;

    RunnableC0991i(ZoomableImageView zoomableImageView, float f, long j, float f2, float f3) {
        this.f3663g = zoomableImageView;
        this.f3659c = f;
        this.f3660d = j;
        this.f3661e = f2;
        this.f3662f = f3;
    }

    @Override // java.lang.Runnable
    public void run() {
        float fMin = Math.min(this.f3659c, System.currentTimeMillis() - this.f3660d);
        float fM3874b = this.f3663g.m3874b(fMin, 0.0f, this.f3661e, this.f3659c);
        float fM3874b2 = this.f3663g.m3874b(fMin, 0.0f, this.f3662f, this.f3659c);
        this.f3663g.m3880a(fM3874b - this.f3657a, fM3874b2 - this.f3658b);
        this.f3663g.m3883a(true, true, false);
        this.f3657a = fM3874b;
        this.f3658b = fM3874b2;
        if (fMin < this.f3659c) {
            this.f3663g.post(this);
        }
    }
}
