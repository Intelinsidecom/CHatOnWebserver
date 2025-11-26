package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ak */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1564ak implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f5982a;

    DialogInterfaceOnClickListenerC1564ak(ChatFragment chatFragment) {
        this.f5982a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
