package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0994bq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4064a;

    DialogInterfaceOnClickListenerC0994bq(ChatFragment chatFragment) {
        this.f4064a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
