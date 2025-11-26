package com.sec.vip.cropimage;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.f */
/* loaded from: classes.dex */
class RunnableC2082f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC2081e f7570a;

    RunnableC2082f(RunnableC2081e runnableC2081e) {
        this.f7570a = runnableC2081e;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f7570a.f7569c.f7505q.f7515a.size() < 1) {
            this.f7570a.m7336a();
        }
        this.f7570a.f7569c.f7505q.invalidate();
        if (this.f7570a.f7569c.f7505q.f7515a.size() == 1) {
            this.f7570a.f7569c.f7491b = (C2077a) this.f7570a.f7569c.f7505q.f7515a.get(0);
            this.f7570a.f7569c.f7491b.m7330a(true);
        }
        this.f7570a.f7569c.m7301d();
    }
}
