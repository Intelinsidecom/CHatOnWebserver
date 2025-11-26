package com.sec.vip.cropimage.honeycomb;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.honeycomb.g */
/* loaded from: classes.dex */
class RunnableC1576g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC1577h f5553a;

    RunnableC1576g(RunnableC1577h runnableC1577h) {
        this.f5553a = runnableC1577h;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5553a.f5554a.m5727b(this.f5553a);
        if (this.f5553a.f5555b != null && this.f5553a.f5555b.getWindow() != null) {
            this.f5553a.f5555b.dismiss();
        }
    }
}
