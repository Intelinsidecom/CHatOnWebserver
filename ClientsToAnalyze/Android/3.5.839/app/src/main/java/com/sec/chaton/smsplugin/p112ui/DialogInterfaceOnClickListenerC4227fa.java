package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;
import android.widget.SimpleAdapter;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3878ac;
import java.util.HashMap;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fa */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4227fa implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SimpleAdapter f15578a;

    /* renamed from: b */
    final /* synthetic */ PluginComposeMessageActivity f15579b;

    DialogInterfaceOnClickListenerC4227fa(PluginComposeMessageActivity pluginComposeMessageActivity, SimpleAdapter simpleAdapter) {
        this.f15579b = pluginComposeMessageActivity;
        this.f15578a = simpleAdapter;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int length;
        int length2;
        String str = (String) ((HashMap) this.f15578a.getItem(i)).get("text");
        if (this.f15579b.f14950V == null || !this.f15579b.f14950V.hasFocus()) {
            this.f15579b.f14943O.append(str);
        } else {
            if (C3847e.m14661aL()) {
                length = C3878ac.m14958b(this.f15579b.f14950V.getText().toString());
                length2 = C3878ac.m14958b(str);
            } else {
                length = this.f15579b.f14950V.length();
                length2 = str.length();
            }
            if (length2 + length <= C3847e.m14635S()) {
                this.f15579b.f14950V.append(str);
            }
        }
        dialogInterface.dismiss();
    }
}
