package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: ActivityManageAccounts.java */
/* renamed from: com.sec.chaton.settings.bc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3512bc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3508az f13000a;

    DialogInterfaceOnClickListenerC3512bc(C3508az c3508az) {
        this.f13000a = c3508az;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f13000a.f12996a.m13402d();
        this.f13000a.f12996a.f12528k.m9356b();
    }
}
