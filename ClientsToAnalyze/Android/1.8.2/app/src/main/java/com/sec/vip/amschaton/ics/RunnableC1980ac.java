package com.sec.vip.amschaton.ics;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ac */
/* loaded from: classes.dex */
class RunnableC1980ac implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f7248a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f7249b;

    RunnableC1980ac(AMSComposerActivity aMSComposerActivity, int i) {
        this.f7249b = aMSComposerActivity;
        this.f7248a = i;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        while (!this.f7249b.m6263b()) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.f7249b.f7179an.sendEmptyMessage(this.f7248a);
    }
}
