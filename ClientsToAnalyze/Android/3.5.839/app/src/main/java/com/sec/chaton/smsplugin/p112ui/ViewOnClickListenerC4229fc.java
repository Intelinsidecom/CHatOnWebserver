package com.sec.chaton.smsplugin.p112ui;

import android.view.View;
import com.sec.chaton.smsplugin.p102b.C3789h;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fc */
/* loaded from: classes.dex */
class ViewOnClickListenerC4229fc implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15582a;

    ViewOnClickListenerC4229fc(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15582a = pluginComposeMessageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = (String) view.getTag();
        this.f15582a.f14996ap.m14447b(str);
        this.f15582a.f14996ap.m14461k();
        this.f15582a.f14938J.m16532a(str);
        this.f15582a.m15988ac();
        C3789h c3789hM14462l = this.f15582a.f14996ap.m14462l();
        if (c3789hM14462l != null) {
            new C4264gk(this.f15582a, this.f15582a.f15048by, c3789hM14462l).start();
        }
    }
}
