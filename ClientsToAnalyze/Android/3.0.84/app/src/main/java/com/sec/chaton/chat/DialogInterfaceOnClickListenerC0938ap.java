package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ap */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0938ap implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f3884a;

    DialogInterfaceOnClickListenerC0938ap(ChatFragment chatFragment) {
        this.f3884a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
