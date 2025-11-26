package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;
import android.widget.CheckBox;
import com.sec.chaton.util.C4809aa;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.di */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4181di implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f15503a;

    /* renamed from: b */
    final /* synthetic */ PluginComposeMessageActivity f15504b;

    DialogInterfaceOnClickListenerC4181di(PluginComposeMessageActivity pluginComposeMessageActivity, CheckBox checkBox) {
        this.f15504b = pluginComposeMessageActivity;
        this.f15503a = checkBox;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C4809aa.m18104a().m18125b("do_not_show_again_charge_dialog", Boolean.valueOf(this.f15503a.isChecked()));
        dialogInterface.cancel();
    }
}
