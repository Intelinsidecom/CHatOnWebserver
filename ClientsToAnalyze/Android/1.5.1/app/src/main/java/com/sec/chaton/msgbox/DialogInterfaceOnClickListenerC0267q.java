package com.sec.chaton.msgbox;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.msgbox.q */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0267q implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f2008a;

    DialogInterfaceOnClickListenerC0267q(MsgboxFragment msgboxFragment) {
        this.f2008a = msgboxFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
