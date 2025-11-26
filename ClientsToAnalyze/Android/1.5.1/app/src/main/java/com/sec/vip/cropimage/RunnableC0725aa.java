package com.sec.vip.cropimage;

/* renamed from: com.sec.vip.cropimage.aa */
/* loaded from: classes.dex */
class RunnableC0725aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC0728ad f4447a;

    RunnableC0725aa(RunnableC0728ad runnableC0728ad) {
        this.f4447a = runnableC0728ad;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4447a.f4451a.m4331b(this.f4447a);
        if (this.f4447a.f4452b.getWindow() != null) {
            this.f4447a.f4452b.dismiss();
        }
    }
}
