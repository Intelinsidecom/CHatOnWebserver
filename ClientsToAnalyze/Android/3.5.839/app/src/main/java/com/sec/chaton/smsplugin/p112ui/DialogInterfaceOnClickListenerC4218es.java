package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;
import android.widget.CheckBox;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.es */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4218es implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f15567a;

    /* renamed from: b */
    final /* synthetic */ CheckBox f15568b;

    /* renamed from: c */
    final /* synthetic */ PluginComposeMessageActivity f15569c;

    DialogInterfaceOnClickListenerC4218es(PluginComposeMessageActivity pluginComposeMessageActivity, int i, CheckBox checkBox) {
        this.f15569c = pluginComposeMessageActivity;
        this.f15567a = i;
        this.f15568b = checkBox;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f15567a) {
            case 7001:
                if (C3847e.m14652aC() && !C4822an.m18218a()) {
                    C4809aa.m18104a().m18125b("pref_key_do_not_show_register_chaton_to_send_large_file", Boolean.valueOf(this.f15568b.isChecked()));
                    break;
                }
                break;
            case 7002:
                if (C3847e.m14652aC() && C4822an.m18218a()) {
                    C4809aa.m18104a().m18125b("pref_key_do_not_show_mobile_network_charge_to_send_large_file", Boolean.valueOf(this.f15568b.isChecked()));
                    break;
                }
                break;
        }
        dialogInterface.cancel();
    }
}
