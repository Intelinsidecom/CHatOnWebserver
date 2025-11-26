package com.sec.vip.cropimage;

/* renamed from: com.sec.vip.cropimage.ac */
/* loaded from: classes.dex */
class RunnableC0727ac implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC0753z f4450a;

    RunnableC0727ac(RunnableC0753z runnableC0753z) {
        this.f4450a = runnableC0753z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4450a.f4522a.m4331b(this.f4450a);
        if (this.f4450a.f4523b.getWindow() != null) {
            this.f4450a.f4523b.dismiss();
        }
    }
}
