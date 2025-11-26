package com.sec.vip.cropimage.honeycomb;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.honeycomb.n */
/* loaded from: classes.dex */
class RunnableC2098n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC2097m f7626a;

    RunnableC2098n(RunnableC2097m runnableC2097m) {
        this.f7626a = runnableC2097m;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7626a.f7621a.m7317b(this.f7626a);
        if (this.f7626a.f7622b != null && this.f7626a.f7622b.getWindow() != null) {
            this.f7626a.f7622b.dismiss();
        }
    }
}
