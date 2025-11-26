package com.sec.chaton.smsplugin.p112ui;

import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fm */
/* loaded from: classes.dex */
class ViewOnClickListenerC4239fm implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15593a;

    ViewOnClickListenerC4239fm(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15593a = pluginComposeMessageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String strM16022ay = this.f15593a.m16022ay();
        if (!TextUtils.isEmpty(strM16022ay)) {
            this.f15593a.m16083h(strM16022ay);
        } else {
            C3890m.m14996b("Mms/compose", "[SpamWarning] showUnknownTab. Invalid unknownNumber.");
        }
    }
}
