package com.sec.chaton.chat;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.chat.s */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0157s implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f979a;

    DialogInterfaceOnClickListenerC0157s(ChatFragment chatFragment) {
        this.f979a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
