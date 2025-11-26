package com.sec.chaton.settings.theme;

/* renamed from: com.sec.chaton.settings.theme.f */
/* loaded from: classes.dex */
class RunnableC0515f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Carousel f3290a;

    /* renamed from: b */
    private Rotator f3291b;

    /* renamed from: c */
    private float f3292c;

    public RunnableC0515f(Carousel carousel) {
        this.f3290a = carousel;
        this.f3291b = new Rotator(carousel.getContext());
    }

    /* renamed from: a */
    private void m3281a() {
        this.f3290a.removeCallbacks(this);
    }

    /* renamed from: a */
    private void m3282a(boolean z) {
        synchronized (this) {
            this.f3291b.m3278a(true);
        }
        if (z) {
            this.f3290a.m3233q();
        }
    }

    /* renamed from: a */
    public void m3283a(float f) {
        if (f == 0.0f) {
            return;
        }
        m3281a();
        float f2 = f < 0.0f ? 360.0f : 0.0f;
        this.f3292c = f2;
        this.f3291b.m3276a(f2, f, 0.0f, 0.0f);
        this.f3290a.post(this);
    }

    /* renamed from: b */
    public void m3284b(float f) {
        if (f == 0.0f) {
            return;
        }
        m3281a();
        this.f3292c = 0.0f;
        synchronized (this) {
            this.f3291b.m3277a(0.0f, -f, this.f3290a.f3204H);
        }
        this.f3290a.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zM3279b;
        float fM3275a;
        float fMax;
        if (this.f3290a.getChildCount() == 0) {
            m3282a(true);
            return;
        }
        this.f3290a.f3219W = false;
        synchronized (this) {
            Rotator rotator = this.f3291b;
            zM3279b = rotator.m3279b();
            fM3275a = rotator.m3275a();
        }
        float f = this.f3292c - fM3275a;
        if (f > 0.0f) {
            this.f3290a.f3207K = this.f3290a.f3223a;
            fMax = Math.min(((this.f3290a.getWidth() - this.f3290a.getPaddingLeft()) - this.f3290a.getPaddingRight()) - 1, f);
        } else {
            this.f3290a.f3207K = (this.f3290a.getChildCount() - 1) + this.f3290a.f3223a;
            fMax = Math.max(-(((this.f3290a.getWidth() - this.f3290a.getPaddingRight()) - this.f3290a.getPaddingLeft()) - 1), f);
        }
        this.f3290a.m3236a(fMax);
        if (!zM3279b || this.f3290a.f3219W) {
            m3282a(true);
        } else {
            this.f3292c = fM3275a;
            this.f3290a.post(this);
        }
    }
}
