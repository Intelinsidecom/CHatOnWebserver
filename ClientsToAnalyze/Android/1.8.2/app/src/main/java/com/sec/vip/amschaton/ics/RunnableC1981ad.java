package com.sec.vip.amschaton.ics;

import android.content.res.Resources;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ad */
/* loaded from: classes.dex */
class RunnableC1981ad implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7250a;

    RunnableC1981ad(AMSComposerActivity aMSComposerActivity) {
        this.f7250a = aMSComposerActivity;
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        this.f7250a.f7147H.dismiss();
        this.f7250a.m6918c(this.f7250a.f7149J);
    }
}
