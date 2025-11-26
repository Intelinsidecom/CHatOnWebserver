package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;

/* compiled from: ManageSimMessages.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ao */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4106ao implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ManageSimMessages f15238a;

    DialogInterfaceOnClickListenerC4106ao(ManageSimMessages manageSimMessages) {
        this.f15238a = manageSimMessages;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f15238a.m15774a(2);
        this.f15238a.m15789e();
        dialogInterface.dismiss();
    }
}
