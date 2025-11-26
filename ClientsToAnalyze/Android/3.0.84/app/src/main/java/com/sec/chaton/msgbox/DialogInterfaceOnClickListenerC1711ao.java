package com.sec.chaton.msgbox;

import android.content.DialogInterface;

/* compiled from: MsgboxSelectionFragment.java */
/* renamed from: com.sec.chaton.msgbox.ao */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1711ao implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxSelectionFragment f6358a;

    DialogInterfaceOnClickListenerC1711ao(MsgboxSelectionFragment msgboxSelectionFragment) {
        this.f6358a = msgboxSelectionFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
