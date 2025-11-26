package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cg */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC1626cg implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6153a;

    DialogInterfaceOnCancelListenerC1626cg(ChatFragment chatFragment) {
        this.f6153a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f6153a.m8010ab();
    }
}
