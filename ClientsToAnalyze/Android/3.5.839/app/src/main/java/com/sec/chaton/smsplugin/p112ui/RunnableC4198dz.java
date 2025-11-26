package com.sec.chaton.smsplugin.p112ui;

import com.sec.chaton.smsplugin.p102b.C3789h;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.dz */
/* loaded from: classes.dex */
class RunnableC4198dz implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3789h f15530a;

    /* renamed from: b */
    final /* synthetic */ RunnableC4197dy f15531b;

    RunnableC4198dz(RunnableC4197dy runnableC4197dy, C3789h c3789h) {
        this.f15531b = runnableC4197dy;
        this.f15530a = c3789h;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15531b.f15529e.f14954Z.m16169a(this.f15530a);
        this.f15531b.f15529e.m16109w();
    }
}
