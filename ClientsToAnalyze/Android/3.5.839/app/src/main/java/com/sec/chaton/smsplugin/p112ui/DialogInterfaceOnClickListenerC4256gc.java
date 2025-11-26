package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4256gc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15619a;

    private DialogInterfaceOnClickListenerC4256gc(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15619a = pluginComposeMessageActivity;
    }

    /* synthetic */ DialogInterfaceOnClickListenerC4256gc(PluginComposeMessageActivity pluginComposeMessageActivity, HandlerC4175dc handlerC4175dc) {
        this(pluginComposeMessageActivity);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f15619a.f14996ap.m14465o();
        dialogInterface.dismiss();
        this.f15619a.finish();
    }
}
