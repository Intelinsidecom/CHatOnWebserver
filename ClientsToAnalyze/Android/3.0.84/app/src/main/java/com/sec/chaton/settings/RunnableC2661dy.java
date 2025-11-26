package com.sec.chaton.settings;

import android.content.res.Configuration;

/* compiled from: FragmentPasswordLockHint.java */
/* renamed from: com.sec.chaton.settings.dy */
/* loaded from: classes.dex */
class RunnableC2661dy implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2660dx f9928a;

    RunnableC2661dy(C2660dx c2660dx) {
        this.f9928a = c2660dx;
    }

    @Override // java.lang.Runnable
    public void run() {
        Configuration configuration = this.f9928a.f9927c.getResources().getConfiguration();
        if (configuration.orientation == 2) {
            this.f9928a.f9926b.showSoftInput(this.f9928a.f9927c.f9166c, 0);
        } else if (configuration.orientation == 1) {
            this.f9928a.f9926b.showSoftInput(this.f9928a.f9927c.f9166c, 1);
        }
    }
}
