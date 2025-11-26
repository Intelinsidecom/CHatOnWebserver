package com.sec.chaton;

import android.content.DialogInterface;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.m */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2568m implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f9196a;

    DialogInterfaceOnClickListenerC2568m(AdminMenu adminMenu) {
        this.f9196a = adminMenu;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f9196a.finish();
    }
}
