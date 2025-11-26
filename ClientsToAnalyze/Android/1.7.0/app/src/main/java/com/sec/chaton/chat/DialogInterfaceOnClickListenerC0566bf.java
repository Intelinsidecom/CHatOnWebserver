package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bf */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0566bf implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1978a;

    DialogInterfaceOnClickListenerC0566bf(ChatFragment chatFragment) {
        this.f1978a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
