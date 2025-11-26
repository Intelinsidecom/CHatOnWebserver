package com.sec.vip.cropimage;

/* renamed from: com.sec.vip.cropimage.p */
/* loaded from: classes.dex */
class RunnableC0743p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC0747t f4509a;

    RunnableC0743p(RunnableC0747t runnableC0747t) {
        this.f4509a = runnableC0747t;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4509a.f4516c.f4375n.f4388a.size() < 1) {
            this.f4509a.m4366a();
        }
        this.f4509a.f4516c.f4375n.invalidate();
        if (this.f4509a.f4516c.f4375n.f4388a.size() == 1) {
            this.f4509a.f4516c.f4363b = (C0742o) this.f4509a.f4516c.f4375n.f4388a.get(0);
            this.f4509a.f4516c.f4363b.m4360a(true);
            this.f4509a.f4516c.f4363b.m4354a(this.f4509a.f4516c.f4378q);
            this.f4509a.f4516c.f4363b.m4356a(this.f4509a.f4516c.f4382u, this.f4509a.f4516c.f4379r, this.f4509a.f4516c.f4377p);
        }
    }
}
