package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.aa */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0923aa implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f3859a;

    DialogInterfaceOnClickListenerC0923aa(ChatFragment chatFragment) {
        this.f3859a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
