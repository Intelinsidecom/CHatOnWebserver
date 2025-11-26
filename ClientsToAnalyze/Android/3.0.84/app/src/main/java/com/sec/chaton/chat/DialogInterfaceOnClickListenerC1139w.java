package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.w */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1139w implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4562a;

    DialogInterfaceOnClickListenerC1139w(ChatFragment chatFragment) {
        this.f4562a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
