package com.sec.vip.amschaton.honeycomb;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.u */
/* loaded from: classes.dex */
class RunnableC1970u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f7117a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f7118b;

    RunnableC1970u(AMSComposerActivity aMSComposerActivity, int i) {
        this.f7118b = aMSComposerActivity;
        this.f7117a = i;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        while (!this.f7118b.m6263b()) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.f7118b.f6945ah.sendEmptyMessage(this.f7117a);
    }
}
