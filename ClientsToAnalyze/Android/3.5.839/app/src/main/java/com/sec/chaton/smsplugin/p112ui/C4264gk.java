package com.sec.chaton.smsplugin.p112ui;

import android.os.Handler;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.smsplugin.p102b.C3789h;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gk */
/* loaded from: classes.dex */
class C4264gk extends Thread {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15631a;

    /* renamed from: b */
    private boolean f15632b = false;

    /* renamed from: c */
    private final Handler f15633c;

    /* renamed from: d */
    private final C3789h f15634d;

    public C4264gk(PluginComposeMessageActivity pluginComposeMessageActivity, Handler handler, C3789h c3789h) {
        this.f15631a = pluginComposeMessageActivity;
        this.f15633c = handler;
        this.f15634d = c3789h;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f15632b = C2198l.m9956i(this.f15631a.getContentResolver(), String.valueOf(this.f15631a.f14935G.m14359d()));
        this.f15633c.post(new RunnableC4265gl(this));
    }
}
