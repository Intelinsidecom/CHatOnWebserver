package com.sec.vip.amschaton.ics;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bx */
/* loaded from: classes.dex */
class RunnableC2028bx implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f7316a;

    RunnableC2028bx(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f7316a = aMSStampSelectionActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (AMSStampSelectionActivity.f7231l) {
            this.f7316a.f7237r.setSelection(0);
        } else {
            this.f7316a.f7237r.setSelection(this.f7316a.f7239t.m6402b() + this.f7316a.f7239t.m6405c());
        }
    }
}
