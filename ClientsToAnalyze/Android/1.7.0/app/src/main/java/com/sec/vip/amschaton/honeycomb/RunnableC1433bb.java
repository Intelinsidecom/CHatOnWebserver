package com.sec.vip.amschaton.honeycomb;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bb */
/* loaded from: classes.dex */
class RunnableC1433bb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5066a;

    RunnableC1433bb(AMSPlayerActivity aMSPlayerActivity) {
        this.f5066a = aMSPlayerActivity;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        while (!this.f5066a.m4740c()) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.f5066a.f4996I.sendEmptyMessage(1000);
    }
}
