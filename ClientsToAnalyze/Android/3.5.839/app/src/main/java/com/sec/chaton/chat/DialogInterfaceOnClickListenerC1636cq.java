package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1636cq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6164a;

    DialogInterfaceOnClickListenerC1636cq(ChatFragment chatFragment) {
        this.f6164a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
