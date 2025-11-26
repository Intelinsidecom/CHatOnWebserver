package com.sec.vip.amschaton.ics;

import android.content.res.Resources;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.be */
/* loaded from: classes.dex */
class RunnableC1501be implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5323a;

    RunnableC1501be(AMSPlayerActivity aMSPlayerActivity) {
        this.f5323a = aMSPlayerActivity;
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        if (!this.f5323a.f5251w) {
            this.f5323a.m5501g(true);
        }
    }
}
