package com.sec.chaton.smsplugin.p112ui;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.eq */
/* loaded from: classes.dex */
class ViewOnClickListenerC4216eq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogInterfaceOnClickListenerC4252fz f15562a;

    /* renamed from: b */
    final /* synthetic */ PluginComposeMessageActivity f15563b;

    ViewOnClickListenerC4216eq(PluginComposeMessageActivity pluginComposeMessageActivity, DialogInterfaceOnClickListenerC4252fz dialogInterfaceOnClickListenerC4252fz) {
        this.f15563b = pluginComposeMessageActivity;
        this.f15562a = dialogInterfaceOnClickListenerC4252fz;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f15562a.m16465a(((CheckBox) view).isChecked());
    }
}
