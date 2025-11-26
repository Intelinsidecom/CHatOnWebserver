package com.sec.vip.cropimage.ics;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.m */
/* loaded from: classes.dex */
class RunnableC2112m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC2111l f7682a;

    RunnableC2112m(RunnableC2111l runnableC2111l) {
        this.f7682a = runnableC2111l;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7682a.f7677a.m7317b(this.f7682a);
        if (this.f7682a.f7678b != null && this.f7682a.f7678b.getWindow() != null) {
            this.f7682a.f7678b.dismiss();
        }
    }
}
