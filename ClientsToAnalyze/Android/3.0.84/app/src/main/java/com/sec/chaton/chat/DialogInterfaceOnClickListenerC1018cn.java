package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cn */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1018cn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4100a;

    DialogInterfaceOnClickListenerC1018cn(ChatFragment chatFragment) {
        this.f4100a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
