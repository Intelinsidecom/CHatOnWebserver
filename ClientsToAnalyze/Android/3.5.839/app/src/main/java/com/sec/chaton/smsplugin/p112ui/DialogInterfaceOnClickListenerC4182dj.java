package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;
import android.widget.CheckBox;
import com.sec.chaton.util.C4809aa;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.dj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4182dj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f15505a;

    /* renamed from: b */
    final /* synthetic */ PluginComposeMessageActivity f15506b;

    DialogInterfaceOnClickListenerC4182dj(PluginComposeMessageActivity pluginComposeMessageActivity, CheckBox checkBox) {
        this.f15506b = pluginComposeMessageActivity;
        this.f15505a = checkBox;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C4809aa.m18104a().m18125b("do_not_show_again_charge_dialog_for_mms", Boolean.valueOf(this.f15505a.isChecked()));
        dialogInterface.cancel();
    }
}
