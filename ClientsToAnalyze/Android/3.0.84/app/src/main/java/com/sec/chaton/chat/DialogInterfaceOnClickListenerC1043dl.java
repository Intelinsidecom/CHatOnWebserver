package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.dl */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1043dl implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1042dk f4154a;

    DialogInterfaceOnClickListenerC1043dl(HandlerC1042dk handlerC1042dk) {
        this.f4154a = handlerC1042dk;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
