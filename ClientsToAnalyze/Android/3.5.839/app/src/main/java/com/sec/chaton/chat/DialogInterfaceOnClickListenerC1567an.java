package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.an */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1567an implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f5987a;

    DialogInterfaceOnClickListenerC1567an(ChatFragment chatFragment) {
        this.f5987a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
