package com.sec.vip.amschaton.fragment;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.cd */
/* loaded from: classes.dex */
class RunnableC3510cd implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f12904a;

    /* renamed from: b */
    final /* synthetic */ AMSStampSelectionFragment f12905b;

    RunnableC3510cd(AMSStampSelectionFragment aMSStampSelectionFragment, int i) {
        this.f12905b = aMSStampSelectionFragment;
        this.f12904a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f12905b.f12752b != null) {
            this.f12905b.f12752b.setSelection(this.f12904a);
        }
    }
}
