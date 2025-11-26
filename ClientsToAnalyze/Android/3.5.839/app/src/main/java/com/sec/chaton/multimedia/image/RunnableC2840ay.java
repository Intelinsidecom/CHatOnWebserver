package com.sec.chaton.multimedia.image;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.chaton.multimedia.image.ay */
/* loaded from: classes.dex */
class RunnableC2840ay implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f10435a;

    RunnableC2840ay(ZoomableImageView zoomableImageView) {
        this.f10435a = zoomableImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        float f = this.f10435a.f10362l / this.f10435a.f10355e;
        if (Math.abs(f - 1.0f) > 0.05d) {
            this.f10435a.f10368r = true;
            if (this.f10435a.f10362l > this.f10435a.f10355e) {
                this.f10435a.f10365o = ((f - 1.0f) * 0.2f) + 1.0f;
                this.f10435a.f10355e *= this.f10435a.f10365o;
                if (this.f10435a.f10355e > this.f10435a.f10362l) {
                    this.f10435a.f10355e /= this.f10435a.f10365o;
                    this.f10435a.f10365o = 1.0f;
                }
            } else {
                this.f10435a.f10365o = 1.0f - ((1.0f - f) * 0.5f);
                this.f10435a.f10355e *= this.f10435a.f10365o;
                if (this.f10435a.f10355e < this.f10435a.f10362l) {
                    this.f10435a.f10355e /= this.f10435a.f10365o;
                    this.f10435a.f10365o = 1.0f;
                }
            }
            if (this.f10435a.f10365o != 1.0f) {
                this.f10435a.f10352b.postScale(this.f10435a.f10365o, this.f10435a.f10365o, this.f10435a.f10363m, this.f10435a.f10364n);
                this.f10435a.f10346D.postDelayed(this.f10435a.f10350H, 15L);
                this.f10435a.invalidate();
                return;
            }
            this.f10435a.f10368r = false;
            this.f10435a.f10365o = 1.0f;
            this.f10435a.f10352b.postScale(this.f10435a.f10362l / this.f10435a.f10355e, this.f10435a.f10362l / this.f10435a.f10355e, this.f10435a.f10363m, this.f10435a.f10364n);
            this.f10435a.f10355e = this.f10435a.f10362l;
            this.f10435a.f10346D.removeCallbacks(this.f10435a.f10350H);
            this.f10435a.invalidate();
            this.f10435a.m11917c();
            return;
        }
        this.f10435a.f10368r = false;
        this.f10435a.f10365o = 1.0f;
        this.f10435a.f10352b.postScale(this.f10435a.f10362l / this.f10435a.f10355e, this.f10435a.f10362l / this.f10435a.f10355e, this.f10435a.f10363m, this.f10435a.f10364n);
        this.f10435a.f10355e = this.f10435a.f10362l;
        this.f10435a.f10346D.removeCallbacks(this.f10435a.f10350H);
        this.f10435a.invalidate();
        this.f10435a.m11917c();
    }
}
