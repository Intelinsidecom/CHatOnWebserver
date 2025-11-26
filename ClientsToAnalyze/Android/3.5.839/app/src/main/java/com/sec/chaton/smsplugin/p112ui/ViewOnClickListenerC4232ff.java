package com.sec.chaton.smsplugin.p112ui;

import android.view.View;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ff */
/* loaded from: classes.dex */
class ViewOnClickListenerC4232ff implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15585a;

    ViewOnClickListenerC4232ff(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15585a = pluginComposeMessageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f15585a.f14935G.m14362g().size() > 0 && !this.f15585a.f14975aU) {
            this.f15585a.m15891L();
        }
    }
}
