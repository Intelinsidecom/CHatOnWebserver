package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fx */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4250fx implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15607a;

    private DialogInterfaceOnClickListenerC4250fx(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15607a = pluginComposeMessageActivity;
    }

    /* synthetic */ DialogInterfaceOnClickListenerC4250fx(PluginComposeMessageActivity pluginComposeMessageActivity, HandlerC4175dc handlerC4175dc) {
        this(pluginComposeMessageActivity);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f15607a.m15878E()) {
            this.f15607a.f14954Z.requestFocus();
        }
        dialogInterface.dismiss();
    }
}
