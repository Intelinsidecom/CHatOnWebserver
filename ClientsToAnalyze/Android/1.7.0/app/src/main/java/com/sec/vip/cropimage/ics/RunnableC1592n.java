package com.sec.vip.cropimage.ics;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.n */
/* loaded from: classes.dex */
class RunnableC1592n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC1579a f5612a;

    RunnableC1592n(RunnableC1579a runnableC1579a) {
        this.f5612a = runnableC1579a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5612a.f5589a.m5727b(this.f5612a);
        if (this.f5612a.f5590b != null && this.f5612a.f5590b.getWindow() != null) {
            this.f5612a.f5590b.dismiss();
        }
    }
}
