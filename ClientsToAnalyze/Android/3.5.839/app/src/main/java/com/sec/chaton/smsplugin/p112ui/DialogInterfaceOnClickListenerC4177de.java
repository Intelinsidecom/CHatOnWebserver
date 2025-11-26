package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.de */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4177de implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15499a;

    DialogInterfaceOnClickListenerC4177de(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15499a = pluginComposeMessageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f15499a.f14954Z.requestFocus();
    }
}
