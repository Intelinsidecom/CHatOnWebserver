package com.sec.chaton.msgbox;

import android.content.DialogInterface;

/* compiled from: MsgboxSelectionFragment.java */
/* renamed from: com.sec.chaton.msgbox.ai */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1705ai implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxSelectionFragment f6351a;

    DialogInterfaceOnClickListenerC1705ai(MsgboxSelectionFragment msgboxSelectionFragment) {
        this.f6351a = msgboxSelectionFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
