package com.sec.chaton;

import android.content.DialogInterface;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.p */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2920p implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f10789a;

    DialogInterfaceOnClickListenerC2920p(AdminMenu adminMenu) {
        this.f10789a = adminMenu;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f10789a.finish();
    }
}
