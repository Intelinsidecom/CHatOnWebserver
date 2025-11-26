package com.sec.chaton.multimedia.image;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.chaton.multimedia.image.av */
/* loaded from: classes.dex */
class RunnableC1871av implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f7124a;

    RunnableC1871av(ZoomableImageView zoomableImageView) {
        this.f7124a = zoomableImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        float f = this.f7124a.f7056l / this.f7124a.f7049e;
        if (Math.abs(f - 1.0f) > 0.05d) {
            this.f7124a.f7062r = true;
            if (this.f7124a.f7056l > this.f7124a.f7049e) {
                this.f7124a.f7059o = ((f - 1.0f) * 0.2f) + 1.0f;
                this.f7124a.f7049e *= this.f7124a.f7059o;
                if (this.f7124a.f7049e > this.f7124a.f7056l) {
                    this.f7124a.f7049e /= this.f7124a.f7059o;
                    this.f7124a.f7059o = 1.0f;
                }
            } else {
                this.f7124a.f7059o = 1.0f - ((1.0f - f) * 0.5f);
                this.f7124a.f7049e *= this.f7124a.f7059o;
                if (this.f7124a.f7049e < this.f7124a.f7056l) {
                    this.f7124a.f7049e /= this.f7124a.f7059o;
                    this.f7124a.f7059o = 1.0f;
                }
            }
            if (this.f7124a.f7059o != 1.0f) {
                this.f7124a.f7046b.postScale(this.f7124a.f7059o, this.f7124a.f7059o, this.f7124a.f7057m, this.f7124a.f7058n);
                this.f7124a.f7040D.postDelayed(this.f7124a.f7044H, 15L);
                this.f7124a.invalidate();
                return;
            }
            this.f7124a.f7062r = false;
            this.f7124a.f7059o = 1.0f;
            this.f7124a.f7046b.postScale(this.f7124a.f7056l / this.f7124a.f7049e, this.f7124a.f7056l / this.f7124a.f7049e, this.f7124a.f7057m, this.f7124a.f7058n);
            this.f7124a.f7049e = this.f7124a.f7056l;
            this.f7124a.f7040D.removeCallbacks(this.f7124a.f7044H);
            this.f7124a.invalidate();
            this.f7124a.m7694c();
            return;
        }
        this.f7124a.f7062r = false;
        this.f7124a.f7059o = 1.0f;
        this.f7124a.f7046b.postScale(this.f7124a.f7056l / this.f7124a.f7049e, this.f7124a.f7056l / this.f7124a.f7049e, this.f7124a.f7057m, this.f7124a.f7058n);
        this.f7124a.f7049e = this.f7124a.f7056l;
        this.f7124a.f7040D.removeCallbacks(this.f7124a.f7044H);
        this.f7124a.invalidate();
        this.f7124a.m7694c();
    }
}
