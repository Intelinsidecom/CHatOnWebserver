package com.sec.chaton.smsplugin.p112ui;

import android.net.Uri;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ee */
/* loaded from: classes.dex */
class RunnableC4204ee implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Uri f15540a;

    /* renamed from: b */
    final /* synthetic */ boolean f15541b;

    /* renamed from: c */
    final /* synthetic */ PluginComposeMessageActivity f15542c;

    RunnableC4204ee(PluginComposeMessageActivity pluginComposeMessageActivity, Uri uri, boolean z) {
        this.f15542c = pluginComposeMessageActivity;
        this.f15540a = uri;
        this.f15541b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15542c.m16054d(this.f15540a, this.f15541b);
    }
}
