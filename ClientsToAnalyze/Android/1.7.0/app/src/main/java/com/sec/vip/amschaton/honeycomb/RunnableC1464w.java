package com.sec.vip.amschaton.honeycomb;

import android.content.res.Resources;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.w */
/* loaded from: classes.dex */
class RunnableC1464w implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f5113a;

    RunnableC1464w(AMSComposerActivity aMSComposerActivity) {
        this.f5113a = aMSComposerActivity;
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        this.f5113a.f4976z.dismiss();
        this.f5113a.m5060c(this.f5113a.f4937B);
    }
}
