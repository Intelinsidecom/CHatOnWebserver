package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatInfoMoreFragment.java */
/* renamed from: com.sec.chaton.chat.dy */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1056dy implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatInfoMoreFragment f4166a;

    DialogInterfaceOnClickListenerC1056dy(ChatInfoMoreFragment chatInfoMoreFragment) {
        this.f4166a = chatInfoMoreFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
