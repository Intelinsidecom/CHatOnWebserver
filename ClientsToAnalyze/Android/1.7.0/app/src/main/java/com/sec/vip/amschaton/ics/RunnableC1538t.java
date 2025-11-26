package com.sec.vip.amschaton.ics;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.t */
/* loaded from: classes.dex */
class RunnableC1538t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f5368a;

    RunnableC1538t(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f5368a = aMSStampSelectionActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (AMSStampSelectionActivity.f5263a) {
            this.f5368a.f5269q.setSelection(0);
        } else {
            this.f5368a.f5269q.setSelection(this.f5368a.f5271s.m5662b() + this.f5368a.f5271s.m5665c());
        }
    }
}
