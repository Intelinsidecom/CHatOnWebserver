package com.sec.vip.cropimage;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.g */
/* loaded from: classes.dex */
class RunnableC3611g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC3610f f13283a;

    RunnableC3611g(RunnableC3610f runnableC3610f) {
        this.f13283a = runnableC3610f;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f13283a.f13282c.f13165c.f13189b.size() < 1) {
            this.f13283a.m12992a();
        }
        this.f13283a.f13282c.f13165c.invalidate();
        if (this.f13283a.f13282c.f13165c.f13189b.size() == 1) {
            this.f13283a.f13282c.f13163a = this.f13283a.f13282c.f13165c.f13189b.get(0);
            this.f13283a.f13282c.f13163a.m13011a(true);
            this.f13283a.f13282c.f13163a.m13004a(this.f13283a.f13282c.f13182u);
            this.f13283a.f13282c.f13163a.m13007a(this.f13283a.f13282c.f13184w, this.f13283a.f13282c.f13183v, this.f13283a.f13282c.f13180s);
        }
        this.f13283a.f13282c.f13165c.onLayout(false, 0, 0, this.f13283a.f13282c.f13165c.getMeasuredWidth(), this.f13283a.f13282c.f13165c.getMeasuredHeight());
        if (this.f13283a.f13282c.f13185x != null && !this.f13283a.f13282c.f13185x.isRecycled()) {
            this.f13283a.f13282c.f13185x.recycle();
            this.f13283a.f13282c.f13185x = null;
        }
    }
}
