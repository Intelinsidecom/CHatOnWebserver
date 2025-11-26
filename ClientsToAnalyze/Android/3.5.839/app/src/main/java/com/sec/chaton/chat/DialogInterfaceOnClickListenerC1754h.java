package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1754h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6582a;

    DialogInterfaceOnClickListenerC1754h(ChatFragment chatFragment) {
        this.f6582a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6582a.f5590bf.clear();
        dialogInterface.cancel();
    }
}
