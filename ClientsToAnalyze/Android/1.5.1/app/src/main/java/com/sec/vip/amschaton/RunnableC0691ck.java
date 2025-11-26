package com.sec.vip.amschaton;

/* renamed from: com.sec.vip.amschaton.ck */
/* loaded from: classes.dex */
class RunnableC0691ck implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4313a;

    RunnableC0691ck(AMSComposerActivity aMSComposerActivity) {
        this.f4313a = aMSComposerActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4313a.f3830F.dismiss();
        this.f4313a.m3751a(this.f4313a.f3832H);
        if (this.f4313a.f3832H == 2002) {
            this.f4313a.f3865p.setEnabled(true);
        }
    }
}
