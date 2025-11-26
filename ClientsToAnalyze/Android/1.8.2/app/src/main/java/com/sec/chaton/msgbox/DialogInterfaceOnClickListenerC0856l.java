package com.sec.chaton.msgbox;

import android.content.DialogInterface;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.l */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0856l implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f3180a;

    DialogInterfaceOnClickListenerC0856l(MsgboxFragment msgboxFragment) {
        this.f3180a = msgboxFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
