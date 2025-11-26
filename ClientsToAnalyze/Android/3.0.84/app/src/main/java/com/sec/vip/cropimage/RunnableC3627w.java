package com.sec.vip.cropimage;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.w */
/* loaded from: classes.dex */
class RunnableC3627w implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC3626v f13337a;

    RunnableC3627w(RunnableC3626v runnableC3626v) {
        this.f13337a = runnableC3626v;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f13337a.f13336c.f13221s.f13229a.size() < 1) {
            this.f13337a.m13017a();
        }
        this.f13337a.f13336c.f13221s.invalidate();
        if (this.f13337a.f13336c.f13221s.f13229a.size() == 1) {
            this.f13337a.f13336c.f13206b = this.f13337a.f13336c.f13221s.f13229a.get(0);
            this.f13337a.f13336c.f13206b.m13011a(true);
        }
        this.f13337a.f13336c.f13221s.onLayout(false, 0, 0, this.f13337a.f13336c.f13221s.getMeasuredWidth(), this.f13337a.f13336c.f13221s.getMeasuredHeight());
    }
}
