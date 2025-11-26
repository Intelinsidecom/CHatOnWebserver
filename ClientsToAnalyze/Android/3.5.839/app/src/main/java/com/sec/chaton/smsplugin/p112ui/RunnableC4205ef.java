package com.sec.chaton.smsplugin.p112ui;

import android.net.Uri;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ef */
/* loaded from: classes.dex */
class RunnableC4205ef implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Uri f15543a;

    /* renamed from: b */
    final /* synthetic */ boolean f15544b;

    /* renamed from: c */
    final /* synthetic */ PluginComposeMessageActivity f15545c;

    RunnableC4205ef(PluginComposeMessageActivity pluginComposeMessageActivity, Uri uri, boolean z) {
        this.f15545c = pluginComposeMessageActivity;
        this.f15543a = uri;
        this.f15544b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15545c.m16077g(this.f15543a, this.f15544b);
    }
}
