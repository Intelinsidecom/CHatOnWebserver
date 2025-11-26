package com.sec.chaton.smsplugin.p112ui;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fh */
/* loaded from: classes.dex */
final class ViewOnClickListenerC4234fh implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogInterfaceOnClickListenerC4254ga f15587a;

    /* renamed from: b */
    final /* synthetic */ CheckBox f15588b;

    ViewOnClickListenerC4234fh(DialogInterfaceOnClickListenerC4254ga dialogInterfaceOnClickListenerC4254ga, CheckBox checkBox) {
        this.f15587a = dialogInterfaceOnClickListenerC4254ga;
        this.f15588b = checkBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f15587a.m16469a(this.f15588b.isChecked());
    }
}
