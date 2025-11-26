package com.sec.chaton.msgbox;

import android.content.DialogInterface;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.n */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1727n implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f6393a;

    DialogInterfaceOnClickListenerC1727n(MsgboxFragment msgboxFragment) {
        this.f6393a = msgboxFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
