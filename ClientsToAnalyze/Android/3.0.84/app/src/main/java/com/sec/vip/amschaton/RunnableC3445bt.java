package com.sec.vip.amschaton;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.vip.amschaton.bt */
/* loaded from: classes.dex */
class RunnableC3445bt implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f12607a;

    RunnableC3445bt(ZoomableImageView zoomableImageView) {
        this.f12607a = zoomableImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Math.abs(this.f12607a.f12417o - this.f12607a.f12414l) < 5.0f && Math.abs(this.f12607a.f12418p - this.f12607a.f12415m) < 5.0f) {
            this.f12607a.f12425w = false;
            this.f12607a.f12406d.removeCallbacks(this.f12607a.f12401I);
            float[] fArr = new float[9];
            this.f12607a.f12410h.getValues(fArr);
            this.f12607a.f12413k = fArr[0];
            this.f12607a.f12414l = fArr[2];
            this.f12607a.f12415m = fArr[5];
            this.f12607a.f12410h.postTranslate(this.f12607a.f12417o - this.f12607a.f12414l, this.f12607a.f12418p - this.f12607a.f12415m);
        } else {
            this.f12607a.f12425w = true;
            float[] fArr2 = new float[9];
            this.f12607a.f12410h.getValues(fArr2);
            this.f12607a.f12413k = fArr2[0];
            this.f12607a.f12414l = fArr2[2];
            this.f12607a.f12415m = fArr2[5];
            this.f12607a.f12410h.postTranslate((this.f12607a.f12417o - this.f12607a.f12414l) * 0.3f, (this.f12607a.f12418p - this.f12607a.f12415m) * 0.3f);
            this.f12607a.f12406d.postDelayed(this, 25L);
        }
        this.f12607a.invalidate();
    }
}
