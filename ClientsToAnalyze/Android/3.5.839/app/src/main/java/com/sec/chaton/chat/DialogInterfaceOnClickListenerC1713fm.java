package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatInfoMoreFragment.java */
/* renamed from: com.sec.chaton.chat.fm */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1713fm implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatInfoMoreFragment f6317a;

    DialogInterfaceOnClickListenerC1713fm(ChatInfoMoreFragment chatInfoMoreFragment) {
        this.f6317a = chatInfoMoreFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
