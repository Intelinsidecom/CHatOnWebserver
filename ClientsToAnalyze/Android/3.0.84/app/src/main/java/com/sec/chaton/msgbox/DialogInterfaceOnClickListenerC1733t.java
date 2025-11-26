package com.sec.chaton.msgbox;

import android.content.DialogInterface;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.t */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1733t implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f6406a;

    DialogInterfaceOnClickListenerC1733t(MsgboxFragment msgboxFragment) {
        this.f6406a = msgboxFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
