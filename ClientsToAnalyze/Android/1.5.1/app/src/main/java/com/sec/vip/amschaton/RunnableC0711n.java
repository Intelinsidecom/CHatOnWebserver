package com.sec.vip.amschaton;

/* renamed from: com.sec.vip.amschaton.n */
/* loaded from: classes.dex */
class RunnableC0711n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f4342a;

    RunnableC0711n(ZoomableImageView zoomableImageView) {
        this.f4342a = zoomableImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        float f = this.f4342a.f4222n / this.f4342a.f4216h;
        if (Math.abs(f - 1.0f) <= 0.05d) {
            this.f4342a.f4228t = false;
            this.f4342a.f4225q = 1.0f;
            this.f4342a.f4213e.postScale(this.f4342a.f4222n / this.f4342a.f4216h, this.f4342a.f4222n / this.f4342a.f4216h, this.f4342a.f4223o, this.f4342a.f4224p);
            this.f4342a.f4216h = this.f4342a.f4222n;
            this.f4342a.f4200F.removeCallbacks(this.f4342a.f4208N);
            this.f4342a.invalidate();
            this.f4342a.m4213b();
            return;
        }
        this.f4342a.f4228t = true;
        if (this.f4342a.f4222n > this.f4342a.f4216h) {
            this.f4342a.f4225q = ((f - 1.0f) * 0.2f) + 1.0f;
            this.f4342a.f4216h *= this.f4342a.f4225q;
            if (this.f4342a.f4216h > this.f4342a.f4222n) {
                this.f4342a.f4216h /= this.f4342a.f4225q;
                this.f4342a.f4225q = 1.0f;
            }
        } else {
            this.f4342a.f4225q = 1.0f - ((1.0f - f) * 0.5f);
            this.f4342a.f4216h *= this.f4342a.f4225q;
            if (this.f4342a.f4216h < this.f4342a.f4222n) {
                this.f4342a.f4216h /= this.f4342a.f4225q;
                this.f4342a.f4225q = 1.0f;
            }
        }
        if (this.f4342a.f4225q != 1.0f) {
            this.f4342a.f4213e.postScale(this.f4342a.f4225q, this.f4342a.f4225q, this.f4342a.f4223o, this.f4342a.f4224p);
            this.f4342a.f4200F.postDelayed(this.f4342a.f4208N, 15L);
            this.f4342a.invalidate();
            return;
        }
        this.f4342a.f4228t = false;
        this.f4342a.f4225q = 1.0f;
        this.f4342a.f4213e.postScale(this.f4342a.f4222n / this.f4342a.f4216h, this.f4342a.f4222n / this.f4342a.f4216h, this.f4342a.f4223o, this.f4342a.f4224p);
        this.f4342a.f4216h = this.f4342a.f4222n;
        this.f4342a.f4200F.removeCallbacks(this.f4342a.f4208N);
        this.f4342a.invalidate();
        this.f4342a.m4213b();
    }
}
