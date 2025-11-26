package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.account.C1002i;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4809aa;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fo */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4241fo implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15595a;

    DialogInterfaceOnClickListenerC4241fo(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15595a = pluginComposeMessageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
            int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
            if (-3 == iM10677a || -2 == iM10677a) {
                C5179v.m19810a(this.f15595a, R.string.trunk_network_not_available, 0).show();
                return;
            } else {
                C4809aa.m18104a().m18125b("buddy_request_sync_in_chaton", (Boolean) true);
                C1002i.m6059a(true);
                return;
            }
        }
        new C2128i(null).m9497a("localsms");
    }
}
