package com.sec.chaton.settings;

import android.content.res.Configuration;

/* compiled from: FragmentPasswordLockHint.java */
/* renamed from: com.sec.chaton.settings.eu */
/* loaded from: classes.dex */
class RunnableC3611eu implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3610et f13144a;

    RunnableC3611eu(C3610et c3610et) {
        this.f13144a = c3610et;
    }

    @Override // java.lang.Runnable
    public void run() {
        Configuration configuration = this.f13144a.f13143c.getResources().getConfiguration();
        if (configuration.orientation == 2) {
            this.f13144a.f13142b.showSoftInput(this.f13144a.f13143c.f12725c, 0);
        } else if (configuration.orientation == 1) {
            this.f13144a.f13142b.showSoftInput(this.f13144a.f13143c.f12725c, 1);
        }
    }
}
