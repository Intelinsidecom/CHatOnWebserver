package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;
import java.io.IOException;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4263gj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15630a;

    private DialogInterfaceOnClickListenerC4263gj(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15630a = pluginComposeMessageActivity;
    }

    /* synthetic */ DialogInterfaceOnClickListenerC4263gj(PluginComposeMessageActivity pluginComposeMessageActivity, HandlerC4175dc handlerC4175dc) {
        this(pluginComposeMessageActivity);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws IOException {
        this.f15630a.m16090j(true);
        dialogInterface.dismiss();
    }
}
