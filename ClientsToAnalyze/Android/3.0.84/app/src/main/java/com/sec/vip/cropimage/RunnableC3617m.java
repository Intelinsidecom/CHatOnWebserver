package com.sec.vip.cropimage;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.m */
/* loaded from: classes.dex */
class RunnableC3617m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC3616l f13295a;

    RunnableC3617m(RunnableC3616l runnableC3616l) {
        this.f13295a = runnableC3616l;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13295a.f13290a.m12976b(this.f13295a);
        if (this.f13295a.f13291b != null && this.f13295a.f13291b.getWindow() != null) {
            this.f13295a.f13291b.dismiss();
        }
    }
}
