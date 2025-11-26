package com.sec.vip.amschaton.ics;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bp */
/* loaded from: classes.dex */
class RunnableC1512bp implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5338a;

    RunnableC1512bp(AMSPlayerActivity aMSPlayerActivity) {
        this.f5338a = aMSPlayerActivity;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        while (!this.f5338a.m4740c()) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.f5338a.f5240G.sendEmptyMessage(1000);
    }
}
