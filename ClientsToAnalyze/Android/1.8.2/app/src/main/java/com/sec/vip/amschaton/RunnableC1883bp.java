package com.sec.vip.amschaton;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.vip.amschaton.bp */
/* loaded from: classes.dex */
class RunnableC1883bp implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f6884a;

    RunnableC1883bp(ZoomableImageView zoomableImageView) {
        this.f6884a = zoomableImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Math.abs(this.f6884a.f6750l - this.f6884a.f6747i) < 5.0f && Math.abs(this.f6884a.f6751m - this.f6884a.f6748j) < 5.0f) {
            this.f6884a.f6758t = false;
            this.f6884a.f6734F.removeCallbacks(this.f6884a.f6737I);
            float[] fArr = new float[9];
            this.f6884a.f6743e.getValues(fArr);
            this.f6884a.f6746h = fArr[0];
            this.f6884a.f6747i = fArr[2];
            this.f6884a.f6748j = fArr[5];
            this.f6884a.f6743e.postTranslate(this.f6884a.f6750l - this.f6884a.f6747i, this.f6884a.f6751m - this.f6884a.f6748j);
        } else {
            this.f6884a.f6758t = true;
            float[] fArr2 = new float[9];
            this.f6884a.f6743e.getValues(fArr2);
            this.f6884a.f6746h = fArr2[0];
            this.f6884a.f6747i = fArr2[2];
            this.f6884a.f6748j = fArr2[5];
            this.f6884a.f6743e.postTranslate((this.f6884a.f6750l - this.f6884a.f6747i) * 0.3f, (this.f6884a.f6751m - this.f6884a.f6748j) * 0.3f);
            this.f6884a.f6734F.postDelayed(this, 25L);
        }
        this.f6884a.invalidate();
    }
}
