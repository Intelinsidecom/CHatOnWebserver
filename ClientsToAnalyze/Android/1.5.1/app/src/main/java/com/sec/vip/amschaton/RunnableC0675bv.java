package com.sec.vip.amschaton;

/* renamed from: com.sec.vip.amschaton.bv */
/* loaded from: classes.dex */
class RunnableC0675bv implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4296a;

    RunnableC0675bv(AMSComposerActivity aMSComposerActivity) {
        this.f4296a = aMSComposerActivity;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        while (!this.f4296a.m3713c()) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.f4296a.f3858ah.sendEmptyMessage(0);
    }
}
