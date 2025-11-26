package com.sec.vip.amschaton;

/* renamed from: com.sec.vip.amschaton.ah */
/* loaded from: classes.dex */
class RunnableC0634ah implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f4245a;

    RunnableC0634ah(AMSPlayerActivity aMSPlayerActivity) {
        this.f4245a = aMSPlayerActivity;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        while (!this.f4245a.m3713c()) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.f4245a.f4025E.sendEmptyMessage(0);
    }
}
