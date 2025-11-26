package com.sec.chaton.multimedia.image;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.chaton.multimedia.image.au */
/* loaded from: classes.dex */
class RunnableC1870au implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f7123a;

    RunnableC1870au(ZoomableImageView zoomableImageView) {
        this.f7123a = zoomableImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Math.abs(this.f7123a.f7054j - this.f7123a.f7050f) < 5.0f && Math.abs(this.f7123a.f7055k - this.f7123a.f7051g) < 5.0f) {
            this.f7123a.f7062r = false;
            this.f7123a.f7040D.removeCallbacks(this.f7123a.f7043G);
            float[] fArr = new float[9];
            this.f7123a.f7046b.getValues(fArr);
            this.f7123a.f7049e = fArr[0];
            this.f7123a.f7050f = fArr[2];
            this.f7123a.f7051g = fArr[5];
            this.f7123a.f7046b.postTranslate(this.f7123a.f7054j - this.f7123a.f7050f, this.f7123a.f7055k - this.f7123a.f7051g);
        } else {
            this.f7123a.f7062r = true;
            float[] fArr2 = new float[9];
            this.f7123a.f7046b.getValues(fArr2);
            this.f7123a.f7049e = fArr2[0];
            this.f7123a.f7050f = fArr2[2];
            this.f7123a.f7051g = fArr2[5];
            this.f7123a.f7046b.postTranslate((this.f7123a.f7054j - this.f7123a.f7050f) * 0.3f, (this.f7123a.f7055k - this.f7123a.f7051g) * 0.3f);
            this.f7123a.f7040D.postDelayed(this, 25L);
        }
        this.f7123a.invalidate();
    }
}
