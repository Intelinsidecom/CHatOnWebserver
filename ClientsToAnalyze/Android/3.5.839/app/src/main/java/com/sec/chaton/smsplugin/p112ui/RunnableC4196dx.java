package com.sec.chaton.smsplugin.p112ui;

import android.app.ProgressDialog;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.dx */
/* loaded from: classes.dex */
class RunnableC4196dx implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ProgressDialog f15523a;

    /* renamed from: b */
    final /* synthetic */ PluginComposeMessageActivity f15524b;

    RunnableC4196dx(PluginComposeMessageActivity pluginComposeMessageActivity, ProgressDialog progressDialog) {
        this.f15524b = pluginComposeMessageActivity;
        this.f15523a = progressDialog;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15523a.show();
    }
}
