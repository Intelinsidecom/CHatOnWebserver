package com.sec.vip.amschaton.honeycomb;

import android.content.res.Resources;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bb */
/* loaded from: classes.dex */
class RunnableC1921bb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7059a;

    RunnableC1921bb(AMSPlayerActivity aMSPlayerActivity) {
        this.f7059a = aMSPlayerActivity;
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        if (!this.f7059a.f6993y) {
            this.f7059a.m6748j(true);
        }
    }
}
