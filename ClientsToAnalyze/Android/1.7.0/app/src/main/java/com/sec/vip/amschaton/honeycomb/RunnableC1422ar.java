package com.sec.vip.amschaton.honeycomb;

import android.content.res.Resources;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.ar */
/* loaded from: classes.dex */
class RunnableC1422ar implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5055a;

    RunnableC1422ar(AMSPlayerActivity aMSPlayerActivity) {
        this.f5055a = aMSPlayerActivity;
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        if (!this.f5055a.f5007w) {
            this.f5055a.m5187i(true);
        }
    }
}
