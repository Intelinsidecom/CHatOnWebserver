package com.sec.chaton.smsplugin.p112ui;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.util.C4878cp;
import com.sec.chaton.util.EnumC4879cq;
import com.sec.common.tooltip.C5013c;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fr */
/* loaded from: classes.dex */
class HandlerC4244fr extends Handler {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15599a;

    HandlerC4244fr(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15599a = pluginComposeMessageActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (C3847e.m14652aC() && C4878cp.m18516a().m18518b(EnumC4879cq.SMS_ATTACH) && !C3847e.m14649a(this.f15599a.f14933E)) {
            View viewInflate = LayoutInflater.from(this.f15599a).inflate(R.layout.large_file_bubble_tip_layout, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R.id.tooltip_attach_textview)).setText(this.f15599a.getString(R.string.tooltip_attach, new Object[]{Integer.valueOf(C3847e.m14653aD() / 1073741824)}));
            new C5013c().m19050a(this.f15599a.f14941M).m19051b(viewInflate).m19048a().m19042a(this.f15599a);
            C4878cp.m18516a().m18517a(EnumC4879cq.SMS_ATTACH);
        }
    }
}
