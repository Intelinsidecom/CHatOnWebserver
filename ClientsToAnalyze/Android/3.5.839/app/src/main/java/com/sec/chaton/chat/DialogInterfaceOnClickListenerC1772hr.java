package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: OfflineMsgDialog.java */
/* renamed from: com.sec.chaton.chat.hr */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1772hr implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ OfflineMsgDialog f6652a;

    DialogInterfaceOnClickListenerC1772hr(OfflineMsgDialog offlineMsgDialog) {
        this.f6652a = offlineMsgDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6652a.m8351a();
        this.f6652a.finish();
    }
}
