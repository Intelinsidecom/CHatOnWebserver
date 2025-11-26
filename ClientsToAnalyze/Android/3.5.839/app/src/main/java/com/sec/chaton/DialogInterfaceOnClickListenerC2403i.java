package com.sec.chaton;

import android.content.DialogInterface;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.i */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2403i implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f8543a;

    DialogInterfaceOnClickListenerC2403i(AdminMenu adminMenu) {
        this.f8543a = adminMenu;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f8543a.finish();
    }
}
