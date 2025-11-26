package com.sec.vip.amschaton;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.vip.amschaton.bu */
/* loaded from: classes.dex */
class RunnableC3446bu implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f12608a;

    RunnableC3446bu(ZoomableImageView zoomableImageView) {
        this.f12608a = zoomableImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        float f = this.f12608a.f12419q / this.f12608a.f12413k;
        if (Math.abs(f - 1.0f) > 0.05d) {
            this.f12608a.f12425w = true;
            if (this.f12608a.f12419q > this.f12608a.f12413k) {
                this.f12608a.f12422t = ((f - 1.0f) * 0.2f) + 1.0f;
                this.f12608a.f12413k *= this.f12608a.f12422t;
                if (this.f12608a.f12413k > this.f12608a.f12419q) {
                    this.f12608a.f12413k /= this.f12608a.f12422t;
                    this.f12608a.f12422t = 1.0f;
                }
            } else {
                this.f12608a.f12422t = 1.0f - ((1.0f - f) * 0.5f);
                this.f12608a.f12413k *= this.f12608a.f12422t;
                if (this.f12608a.f12413k < this.f12608a.f12419q) {
                    this.f12608a.f12413k /= this.f12608a.f12422t;
                    this.f12608a.f12422t = 1.0f;
                }
            }
            if (this.f12608a.f12422t != 1.0f) {
                this.f12608a.f12410h.postScale(this.f12608a.f12422t, this.f12608a.f12422t, this.f12608a.f12420r, this.f12608a.f12421s);
                this.f12608a.f12406d.postDelayed(this.f12608a.f12402J, 15L);
                this.f12608a.invalidate();
                return;
            }
            this.f12608a.f12425w = false;
            this.f12608a.f12422t = 1.0f;
            this.f12608a.f12410h.postScale(this.f12608a.f12419q / this.f12608a.f12413k, this.f12608a.f12419q / this.f12608a.f12413k, this.f12608a.f12420r, this.f12608a.f12421s);
            this.f12608a.f12413k = this.f12608a.f12419q;
            this.f12608a.f12406d.removeCallbacks(this.f12608a.f12402J);
            this.f12608a.invalidate();
            this.f12608a.m12089b();
            return;
        }
        this.f12608a.f12425w = false;
        this.f12608a.f12422t = 1.0f;
        this.f12608a.f12410h.postScale(this.f12608a.f12419q / this.f12608a.f12413k, this.f12608a.f12419q / this.f12608a.f12413k, this.f12608a.f12420r, this.f12608a.f12421s);
        this.f12608a.f12413k = this.f12608a.f12419q;
        this.f12608a.f12406d.removeCallbacks(this.f12608a.f12402J);
        this.f12608a.invalidate();
        this.f12608a.m12089b();
    }
}
