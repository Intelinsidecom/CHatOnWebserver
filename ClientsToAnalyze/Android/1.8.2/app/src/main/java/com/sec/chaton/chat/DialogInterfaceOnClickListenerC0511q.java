package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.q */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0511q implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f2121a;

    DialogInterfaceOnClickListenerC0511q(ChatFragment chatFragment) {
        this.f2121a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
