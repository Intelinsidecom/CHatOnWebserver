package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.util.C4809aa;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fu */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4247fu implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15602a;

    DialogInterfaceOnClickListenerC4247fu(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15602a = pluginComposeMessageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C4809aa.m18104a().m18125b("pref_key_using_sms_mms_mode", (Boolean) true);
        dialogInterface.cancel();
        if (!C3847e.m14654aE()) {
            this.f15602a.m16115z();
            this.f15602a.f15044bu = true;
        }
    }
}
