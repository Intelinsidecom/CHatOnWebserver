package com.sec.vip.cropimage;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.i */
/* loaded from: classes.dex */
class RunnableC5122i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC5121h f18695a;

    RunnableC5122i(RunnableC5121h runnableC5121h) {
        this.f18695a = runnableC5121h;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f18695a.f18694c.f18612E.f18641a.size() < 1) {
            this.f18695a.m19584a();
        }
        this.f18695a.f18694c.f18612E.invalidate();
        if (this.f18695a.f18694c.f18612E.f18641a.size() == 1) {
            this.f18695a.f18694c.f18630o = this.f18695a.f18694c.f18612E.f18641a.get(0);
            this.f18695a.f18694c.f18630o.m19578a(true);
        }
        this.f18695a.f18694c.f18612E.onLayout(false, 0, 0, this.f18695a.f18694c.f18612E.getMeasuredWidth(), this.f18695a.f18694c.f18612E.getMeasuredHeight());
    }
}
