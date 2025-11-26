package com.sec.vip.amschaton.ics;

import android.content.res.Resources;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bc */
/* loaded from: classes.dex */
class RunnableC2007bc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7289a;

    RunnableC2007bc(AMSPlayerActivity aMSPlayerActivity) {
        this.f7289a = aMSPlayerActivity;
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        if (!this.f7289a.f7222y) {
            this.f7289a.m7061g(true);
        }
    }
}
