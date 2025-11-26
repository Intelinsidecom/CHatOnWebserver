package com.sec.vip.amschaton.ics;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ab */
/* loaded from: classes.dex */
class RunnableC1471ab implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f5278a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f5279b;

    RunnableC1471ab(AMSComposerActivity aMSComposerActivity, int i) {
        this.f5279b = aMSComposerActivity;
        this.f5278a = i;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        while (!this.f5279b.m4740c()) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.f5279b.f5208ac.sendEmptyMessage(this.f5278a);
    }
}
