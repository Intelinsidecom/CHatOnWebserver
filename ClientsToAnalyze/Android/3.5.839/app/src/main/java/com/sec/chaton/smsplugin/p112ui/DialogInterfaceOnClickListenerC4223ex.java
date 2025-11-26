package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ex */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4223ex implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15574a;

    DialogInterfaceOnClickListenerC4223ex(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15574a = pluginComposeMessageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f15574a.finish();
    }
}
