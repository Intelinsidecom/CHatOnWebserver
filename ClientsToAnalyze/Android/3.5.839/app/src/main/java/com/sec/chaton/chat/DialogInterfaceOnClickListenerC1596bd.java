package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bd */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1596bd implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6101a;

    DialogInterfaceOnClickListenerC1596bd(ChatFragment chatFragment) {
        this.f6101a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
