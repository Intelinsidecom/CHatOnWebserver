package com.sec.vip.amschaton;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.vip.amschaton.bq */
/* loaded from: classes.dex */
class RunnableC1884bq implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f6885a;

    RunnableC1884bq(ZoomableImageView zoomableImageView) {
        this.f6885a = zoomableImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        float f = this.f6885a.f6752n / this.f6885a.f6746h;
        if (Math.abs(f - 1.0f) > 0.05d) {
            this.f6885a.f6758t = true;
            if (this.f6885a.f6752n > this.f6885a.f6746h) {
                this.f6885a.f6755q = ((f - 1.0f) * 0.2f) + 1.0f;
                this.f6885a.f6746h *= this.f6885a.f6755q;
                if (this.f6885a.f6746h > this.f6885a.f6752n) {
                    this.f6885a.f6746h /= this.f6885a.f6755q;
                    this.f6885a.f6755q = 1.0f;
                }
            } else {
                this.f6885a.f6755q = 1.0f - ((1.0f - f) * 0.5f);
                this.f6885a.f6746h *= this.f6885a.f6755q;
                if (this.f6885a.f6746h < this.f6885a.f6752n) {
                    this.f6885a.f6746h /= this.f6885a.f6755q;
                    this.f6885a.f6755q = 1.0f;
                }
            }
            if (this.f6885a.f6755q != 1.0f) {
                this.f6885a.f6743e.postScale(this.f6885a.f6755q, this.f6885a.f6755q, this.f6885a.f6753o, this.f6885a.f6754p);
                this.f6885a.f6734F.postDelayed(this.f6885a.f6738J, 15L);
                this.f6885a.invalidate();
                return;
            }
            this.f6885a.f6758t = false;
            this.f6885a.f6755q = 1.0f;
            this.f6885a.f6743e.postScale(this.f6885a.f6752n / this.f6885a.f6746h, this.f6885a.f6752n / this.f6885a.f6746h, this.f6885a.f6753o, this.f6885a.f6754p);
            this.f6885a.f6746h = this.f6885a.f6752n;
            this.f6885a.f6734F.removeCallbacks(this.f6885a.f6738J);
            this.f6885a.invalidate();
            this.f6885a.m6377b();
            return;
        }
        this.f6885a.f6758t = false;
        this.f6885a.f6755q = 1.0f;
        this.f6885a.f6743e.postScale(this.f6885a.f6752n / this.f6885a.f6746h, this.f6885a.f6752n / this.f6885a.f6746h, this.f6885a.f6753o, this.f6885a.f6754p);
        this.f6885a.f6746h = this.f6885a.f6752n;
        this.f6885a.f6734F.removeCallbacks(this.f6885a.f6738J);
        this.f6885a.invalidate();
        this.f6885a.m6377b();
    }
}
