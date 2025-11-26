package com.sec.chaton;

import android.content.DialogInterface;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.e */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2172e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f7802a;

    DialogInterfaceOnClickListenerC2172e(AdminMenu adminMenu) {
        this.f7802a = adminMenu;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }
}
