package com.sec.chaton.smsplugin.p112ui;

import android.net.Uri;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.eg */
/* loaded from: classes.dex */
class RunnableC4206eg implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f15546a;

    /* renamed from: b */
    final /* synthetic */ Uri f15547b;

    /* renamed from: c */
    final /* synthetic */ PluginComposeMessageActivity f15548c;

    RunnableC4206eg(PluginComposeMessageActivity pluginComposeMessageActivity, String str, Uri uri) {
        this.f15548c = pluginComposeMessageActivity;
        this.f15546a = str;
        this.f15547b = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15548c.m15967a(this.f15546a, this.f15547b, false);
    }
}
