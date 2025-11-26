package com.sec.vip.amschaton.honeycomb;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.x */
/* loaded from: classes.dex */
class RunnableC1465x implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f5114a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f5115b;

    RunnableC1465x(AMSComposerActivity aMSComposerActivity, int i) {
        this.f5115b = aMSComposerActivity;
        this.f5114a = i;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        while (!this.f5115b.m4740c()) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.f5115b.f4961Z.sendEmptyMessage(this.f5114a);
    }
}
