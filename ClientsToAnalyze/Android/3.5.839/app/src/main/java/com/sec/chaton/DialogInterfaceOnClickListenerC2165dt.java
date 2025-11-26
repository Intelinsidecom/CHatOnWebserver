package com.sec.chaton;

import android.content.DialogInterface;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.dt */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2165dt implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7794a;

    DialogInterfaceOnClickListenerC2165dt(TabActivity tabActivity) {
        this.f7794a = tabActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
