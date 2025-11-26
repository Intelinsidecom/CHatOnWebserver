package com.sec.vip.amschaton;

/* renamed from: com.sec.vip.amschaton.m */
/* loaded from: classes.dex */
class RunnableC0710m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f4341a;

    RunnableC0710m(ZoomableImageView zoomableImageView) {
        this.f4341a = zoomableImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Math.abs(this.f4341a.f4220l - this.f4341a.f4217i) >= 5.0f || Math.abs(this.f4341a.f4221m - this.f4341a.f4218j) >= 5.0f) {
            this.f4341a.f4228t = true;
            float[] fArr = new float[9];
            this.f4341a.f4213e.getValues(fArr);
            this.f4341a.f4216h = fArr[0];
            this.f4341a.f4217i = fArr[2];
            this.f4341a.f4218j = fArr[5];
            this.f4341a.f4213e.postTranslate((this.f4341a.f4220l - this.f4341a.f4217i) * 0.3f, (this.f4341a.f4221m - this.f4341a.f4218j) * 0.3f);
            this.f4341a.f4200F.postDelayed(this, 25L);
        } else {
            this.f4341a.f4228t = false;
            this.f4341a.f4200F.removeCallbacks(this.f4341a.f4207M);
            float[] fArr2 = new float[9];
            this.f4341a.f4213e.getValues(fArr2);
            this.f4341a.f4216h = fArr2[0];
            this.f4341a.f4217i = fArr2[2];
            this.f4341a.f4218j = fArr2[5];
            this.f4341a.f4213e.postTranslate(this.f4341a.f4220l - this.f4341a.f4217i, this.f4341a.f4221m - this.f4341a.f4218j);
        }
        this.f4341a.invalidate();
    }
}
