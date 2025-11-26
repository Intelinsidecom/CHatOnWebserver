package com.sec.chaton;

import android.content.DialogInterface;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.e */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1349e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f5087a;

    DialogInterfaceOnClickListenerC1349e(AdminMenu adminMenu) {
        this.f5087a = adminMenu;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f5087a.finish();
    }
}
