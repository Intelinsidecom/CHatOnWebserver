package com.sec.chaton.smsplugin.p112ui;

import android.net.Uri;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ed */
/* loaded from: classes.dex */
class RunnableC4203ed implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Uri f15537a;

    /* renamed from: b */
    final /* synthetic */ boolean f15538b;

    /* renamed from: c */
    final /* synthetic */ PluginComposeMessageActivity f15539c;

    RunnableC4203ed(PluginComposeMessageActivity pluginComposeMessageActivity, Uri uri, boolean z) {
        this.f15539c = pluginComposeMessageActivity;
        this.f15537a = uri;
        this.f15538b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15539c.m16026b(this.f15537a, this.f15538b);
    }
}
