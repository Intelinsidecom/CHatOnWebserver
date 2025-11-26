package com.sec.chaton.smsplugin.p112ui;

import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fl */
/* loaded from: classes.dex */
class ViewOnClickListenerC4238fl implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15592a;

    ViewOnClickListenerC4238fl(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15592a = pluginComposeMessageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String strM16022ay = this.f15592a.m16022ay();
        if (TextUtils.isEmpty(strM16022ay)) {
            C3890m.m14996b("Mms/compose", "[SpamWarning] showUnknownTab. Invalid unknownNumber.");
        } else if (C1736gi.m8651c(strM16022ay) != -1) {
            this.f15592a.m16079g(strM16022ay);
        } else {
            this.f15592a.m16124d(strM16022ay);
        }
    }
}
