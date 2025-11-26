package com.sec.chaton.multimedia.image;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.chaton.multimedia.image.ax */
/* loaded from: classes.dex */
class RunnableC2839ax implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f10434a;

    RunnableC2839ax(ZoomableImageView zoomableImageView) {
        this.f10434a = zoomableImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Math.abs(this.f10434a.f10360j - this.f10434a.f10356f) < 5.0f && Math.abs(this.f10434a.f10361k - this.f10434a.f10357g) < 5.0f) {
            this.f10434a.f10368r = false;
            this.f10434a.f10346D.removeCallbacks(this.f10434a.f10349G);
            float[] fArr = new float[9];
            this.f10434a.f10352b.getValues(fArr);
            this.f10434a.f10355e = fArr[0];
            this.f10434a.f10356f = fArr[2];
            this.f10434a.f10357g = fArr[5];
            this.f10434a.f10352b.postTranslate(this.f10434a.f10360j - this.f10434a.f10356f, this.f10434a.f10361k - this.f10434a.f10357g);
        } else {
            this.f10434a.f10368r = true;
            float[] fArr2 = new float[9];
            this.f10434a.f10352b.getValues(fArr2);
            this.f10434a.f10355e = fArr2[0];
            this.f10434a.f10356f = fArr2[2];
            this.f10434a.f10357g = fArr2[5];
            this.f10434a.f10352b.postTranslate((this.f10434a.f10360j - this.f10434a.f10356f) * 0.3f, (this.f10434a.f10361k - this.f10434a.f10357g) * 0.3f);
            this.f10434a.f10346D.postDelayed(this, 25L);
        }
        this.f10434a.invalidate();
    }
}
