package com.sec.chaton.msgbox;

import android.content.DialogInterface;

/* compiled from: MsgboxClose.java */
/* renamed from: com.sec.chaton.msgbox.s */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2674s implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C2660e f9585a;

    DialogInterfaceOnClickListenerC2674s(C2660e c2660e) {
        this.f9585a = c2660e;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
