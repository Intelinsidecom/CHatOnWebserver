package com.sec.vip.amschaton.ics;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.at */
/* loaded from: classes.dex */
class RunnableC1997at implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7277a;

    RunnableC1997at(AMSPlayerActivity aMSPlayerActivity) {
        this.f7277a = aMSPlayerActivity;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        while (!this.f7277a.m6263b()) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.f7277a.f7211I.sendEmptyMessage(1000);
    }
}
