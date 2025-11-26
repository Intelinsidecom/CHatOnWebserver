package com.sec.vip.amschaton;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.vip.amschaton.g */
/* loaded from: classes.dex */
class RunnableC1402g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f4924a;

    RunnableC1402g(ZoomableImageView zoomableImageView) {
        this.f4924a = zoomableImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        float f = this.f4924a.f4764n / this.f4924a.f4758h;
        if (Math.abs(f - 1.0f) > 0.05d) {
            this.f4924a.f4770t = true;
            if (this.f4924a.f4764n > this.f4924a.f4758h) {
                this.f4924a.f4767q = ((f - 1.0f) * 0.2f) + 1.0f;
                this.f4924a.f4758h *= this.f4924a.f4767q;
                if (this.f4924a.f4758h > this.f4924a.f4764n) {
                    this.f4924a.f4758h /= this.f4924a.f4767q;
                    this.f4924a.f4767q = 1.0f;
                }
            } else {
                this.f4924a.f4767q = 1.0f - ((1.0f - f) * 0.5f);
                this.f4924a.f4758h *= this.f4924a.f4767q;
                if (this.f4924a.f4758h < this.f4924a.f4764n) {
                    this.f4924a.f4758h /= this.f4924a.f4767q;
                    this.f4924a.f4767q = 1.0f;
                }
            }
            if (this.f4924a.f4767q != 1.0f) {
                this.f4924a.f4755e.postScale(this.f4924a.f4767q, this.f4924a.f4767q, this.f4924a.f4765o, this.f4924a.f4766p);
                this.f4924a.f4746F.postDelayed(this.f4924a.f4750J, 15L);
                this.f4924a.invalidate();
                return;
            }
            this.f4924a.f4770t = false;
            this.f4924a.f4767q = 1.0f;
            this.f4924a.f4755e.postScale(this.f4924a.f4764n / this.f4924a.f4758h, this.f4924a.f4764n / this.f4924a.f4758h, this.f4924a.f4765o, this.f4924a.f4766p);
            this.f4924a.f4758h = this.f4924a.f4764n;
            this.f4924a.f4746F.removeCallbacks(this.f4924a.f4750J);
            this.f4924a.invalidate();
            this.f4924a.m4852b();
            return;
        }
        this.f4924a.f4770t = false;
        this.f4924a.f4767q = 1.0f;
        this.f4924a.f4755e.postScale(this.f4924a.f4764n / this.f4924a.f4758h, this.f4924a.f4764n / this.f4924a.f4758h, this.f4924a.f4765o, this.f4924a.f4766p);
        this.f4924a.f4758h = this.f4924a.f4764n;
        this.f4924a.f4746F.removeCallbacks(this.f4924a.f4750J);
        this.f4924a.invalidate();
        this.f4924a.m4852b();
    }
}
