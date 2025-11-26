package com.sec.chaton.smsplugin.p112ui;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: PluginConversationList.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gq */
/* loaded from: classes.dex */
final class ViewOnClickListenerC4270gq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogInterfaceOnClickListenerC4273gt f15642a;

    /* renamed from: b */
    final /* synthetic */ CheckBox f15643b;

    ViewOnClickListenerC4270gq(DialogInterfaceOnClickListenerC4273gt dialogInterfaceOnClickListenerC4273gt, CheckBox checkBox) {
        this.f15642a = dialogInterfaceOnClickListenerC4273gt;
        this.f15643b = checkBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f15642a.m16479a(this.f15643b.isChecked());
    }
}
