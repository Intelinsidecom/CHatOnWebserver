package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fs */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4245fs implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15600a;

    DialogInterfaceOnClickListenerC4245fs(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15600a = pluginComposeMessageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        this.f15600a.finish();
    }
}
