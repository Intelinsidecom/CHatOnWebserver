package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cn */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1633cn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6160a;

    DialogInterfaceOnClickListenerC1633cn(ChatFragment chatFragment) {
        this.f6160a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
