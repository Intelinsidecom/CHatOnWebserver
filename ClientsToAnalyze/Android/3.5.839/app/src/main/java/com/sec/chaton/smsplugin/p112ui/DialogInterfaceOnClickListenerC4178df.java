package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.df */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4178df implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15500a;

    DialogInterfaceOnClickListenerC4178df(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15500a = pluginComposeMessageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
