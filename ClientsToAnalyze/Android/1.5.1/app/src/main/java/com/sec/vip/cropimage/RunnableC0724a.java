package com.sec.vip.cropimage;

/* renamed from: com.sec.vip.cropimage.a */
/* loaded from: classes.dex */
class RunnableC0724a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC0740m f4446a;

    RunnableC0724a(RunnableC0740m runnableC0740m) {
        this.f4446a = runnableC0740m;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4446a.f4482c.f4413o.f4425a.size() < 1) {
            this.f4446a.m4346a();
        }
        this.f4446a.f4482c.f4413o.invalidate();
        if (this.f4446a.f4482c.f4413o.f4425a.size() == 1) {
            this.f4446a.f4482c.f4400b = (C0742o) this.f4446a.f4482c.f4413o.f4425a.get(0);
            this.f4446a.f4482c.f4400b.m4360a(true);
        }
    }
}
