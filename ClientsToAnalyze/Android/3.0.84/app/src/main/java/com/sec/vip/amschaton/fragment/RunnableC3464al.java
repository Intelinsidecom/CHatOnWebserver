package com.sec.vip.amschaton.fragment;

import android.content.res.Resources;

/* compiled from: AMSComposerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.al */
/* loaded from: classes.dex */
class RunnableC3464al implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSComposerFragment f12824a;

    RunnableC3464al(AMSComposerFragment aMSComposerFragment) {
        this.f12824a = aMSComposerFragment;
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        this.f12824a.f12653A.dismiss();
        this.f12824a.m12449c(this.f12824a.f12655C);
    }
}
