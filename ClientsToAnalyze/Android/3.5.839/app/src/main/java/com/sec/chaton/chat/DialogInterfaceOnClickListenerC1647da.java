package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.da */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1647da implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6179a;

    DialogInterfaceOnClickListenerC1647da(ChatFragment chatFragment) {
        this.f6179a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
