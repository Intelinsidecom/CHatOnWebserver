package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bo */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0992bo implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4062a;

    DialogInterfaceOnClickListenerC0992bo(ChatFragment chatFragment) {
        this.f4062a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
