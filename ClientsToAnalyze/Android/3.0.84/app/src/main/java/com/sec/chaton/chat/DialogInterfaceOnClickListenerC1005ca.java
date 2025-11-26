package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ca */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1005ca implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4079a;

    DialogInterfaceOnClickListenerC1005ca(ChatFragment chatFragment) {
        this.f4079a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
