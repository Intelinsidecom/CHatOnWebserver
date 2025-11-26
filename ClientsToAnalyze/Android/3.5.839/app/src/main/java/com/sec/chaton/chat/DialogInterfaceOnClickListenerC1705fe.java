package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.fe */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1705fe implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1704fd f6310a;

    DialogInterfaceOnClickListenerC1705fe(HandlerC1704fd handlerC1704fd) {
        this.f6310a = handlerC1704fd;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
