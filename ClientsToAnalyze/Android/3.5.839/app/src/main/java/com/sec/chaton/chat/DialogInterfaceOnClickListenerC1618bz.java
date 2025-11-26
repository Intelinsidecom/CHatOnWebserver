package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bz */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1618bz implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogInterfaceOnClickListenerC1617by f6142a;

    DialogInterfaceOnClickListenerC1618bz(DialogInterfaceOnClickListenerC1617by dialogInterfaceOnClickListenerC1617by) {
        this.f6142a = dialogInterfaceOnClickListenerC1617by;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
