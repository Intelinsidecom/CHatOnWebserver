package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.do */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1661do implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6205a;

    DialogInterfaceOnClickListenerC1661do(ChatFragment chatFragment) {
        this.f6205a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
