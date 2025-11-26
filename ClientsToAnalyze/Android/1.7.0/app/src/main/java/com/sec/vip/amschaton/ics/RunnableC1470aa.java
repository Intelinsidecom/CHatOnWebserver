package com.sec.vip.amschaton.ics;

import android.content.res.Resources;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.aa */
/* loaded from: classes.dex */
class RunnableC1470aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f5277a;

    RunnableC1470aa(AMSComposerActivity aMSComposerActivity) {
        this.f5277a = aMSComposerActivity;
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        this.f5277a.f5223z.dismiss();
        this.f5277a.m5365c(this.f5277a.f5181B);
    }
}
