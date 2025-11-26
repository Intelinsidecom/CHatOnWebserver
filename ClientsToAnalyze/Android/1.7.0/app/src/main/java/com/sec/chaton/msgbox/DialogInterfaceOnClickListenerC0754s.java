package com.sec.chaton.msgbox;

import android.content.DialogInterface;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.s */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0754s implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f2558a;

    DialogInterfaceOnClickListenerC0754s(MsgboxFragment msgboxFragment) {
        this.f2558a = msgboxFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
