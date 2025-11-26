package com.sec.chaton;

import android.content.DialogInterface;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.g */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1482g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f5489a;

    DialogInterfaceOnClickListenerC1482g(AdminMenu adminMenu) {
        this.f5489a = adminMenu;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f5489a.finish();
    }
}
