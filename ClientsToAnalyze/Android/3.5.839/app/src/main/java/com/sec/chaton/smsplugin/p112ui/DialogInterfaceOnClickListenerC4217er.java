package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.widget.CheckBox;
import com.sec.chaton.registration.EnumC3297gd;
import com.sec.chaton.registration.RegisterSMSActivity;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import java.io.IOException;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.er */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4217er implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f15564a;

    /* renamed from: b */
    final /* synthetic */ CheckBox f15565b;

    /* renamed from: c */
    final /* synthetic */ PluginComposeMessageActivity f15566c;

    DialogInterfaceOnClickListenerC4217er(PluginComposeMessageActivity pluginComposeMessageActivity, int i, CheckBox checkBox) {
        this.f15566c = pluginComposeMessageActivity;
        this.f15564a = i;
        this.f15565b = checkBox;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws IOException {
        switch (this.f15564a) {
            case 7001:
                if (C3847e.m14652aC() && !C4822an.m18218a()) {
                    C4809aa.m18104a().m18125b("pref_key_do_not_show_register_chaton_to_send_large_file", Boolean.valueOf(this.f15565b.isChecked()));
                    Intent intent = new Intent(this.f15566c.getApplicationContext(), (Class<?>) RegisterSMSActivity.class);
                    intent.putExtra("request_register", EnumC3297gd.reigster);
                    this.f15566c.startActivity(intent);
                    break;
                }
                break;
            case 7002:
                if (C3847e.m14652aC() && C4822an.m18218a()) {
                    C4809aa.m18104a().m18125b("pref_key_do_not_show_mobile_network_charge_to_send_large_file", Boolean.valueOf(this.f15565b.isChecked()));
                    this.f15566c.m15982aI();
                    break;
                }
                break;
        }
    }
}
