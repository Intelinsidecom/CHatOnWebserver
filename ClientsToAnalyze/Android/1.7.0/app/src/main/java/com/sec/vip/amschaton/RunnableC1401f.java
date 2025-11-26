package com.sec.vip.amschaton;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.vip.amschaton.f */
/* loaded from: classes.dex */
class RunnableC1401f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f4923a;

    RunnableC1401f(ZoomableImageView zoomableImageView) {
        this.f4923a = zoomableImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Math.abs(this.f4923a.f4762l - this.f4923a.f4759i) < 5.0f && Math.abs(this.f4923a.f4763m - this.f4923a.f4760j) < 5.0f) {
            this.f4923a.f4770t = false;
            this.f4923a.f4746F.removeCallbacks(this.f4923a.f4749I);
            float[] fArr = new float[9];
            this.f4923a.f4755e.getValues(fArr);
            this.f4923a.f4758h = fArr[0];
            this.f4923a.f4759i = fArr[2];
            this.f4923a.f4760j = fArr[5];
            this.f4923a.f4755e.postTranslate(this.f4923a.f4762l - this.f4923a.f4759i, this.f4923a.f4763m - this.f4923a.f4760j);
        } else {
            this.f4923a.f4770t = true;
            float[] fArr2 = new float[9];
            this.f4923a.f4755e.getValues(fArr2);
            this.f4923a.f4758h = fArr2[0];
            this.f4923a.f4759i = fArr2[2];
            this.f4923a.f4760j = fArr2[5];
            this.f4923a.f4755e.postTranslate((this.f4923a.f4762l - this.f4923a.f4759i) * 0.3f, (this.f4923a.f4763m - this.f4923a.f4760j) * 0.3f);
            this.f4923a.f4746F.postDelayed(this, 25L);
        }
        this.f4923a.invalidate();
    }
}
