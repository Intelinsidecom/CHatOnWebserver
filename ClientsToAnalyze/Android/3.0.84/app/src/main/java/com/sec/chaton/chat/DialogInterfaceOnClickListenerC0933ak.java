package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ak */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0933ak implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f3878a;

    DialogInterfaceOnClickListenerC0933ak(ChatFragment chatFragment) {
        this.f3878a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
