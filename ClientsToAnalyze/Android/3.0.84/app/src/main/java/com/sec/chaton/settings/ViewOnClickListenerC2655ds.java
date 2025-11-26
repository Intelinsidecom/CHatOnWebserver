package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.R;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: FragmentMultiDeviceView.java */
/* renamed from: com.sec.chaton.settings.ds */
/* loaded from: classes.dex */
class ViewOnClickListenerC2655ds implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f9919a;

    /* renamed from: b */
    final /* synthetic */ C2654dr f9920b;

    ViewOnClickListenerC2655ds(C2654dr c2654dr, String str) {
        this.f9920b = c2654dr;
        this.f9919a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AbstractC3271a.m11494a(this.f9920b.f9914a.f9153d).mo11495a(R.string.deregister_device).mo11506b(R.string.multideivce_delete_account2).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2657du(this)).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2656dt(this)).mo11505a().show();
    }
}
