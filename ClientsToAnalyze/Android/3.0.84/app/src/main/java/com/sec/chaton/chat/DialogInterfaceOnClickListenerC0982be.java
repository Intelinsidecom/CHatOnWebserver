package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.be */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0982be implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogInterfaceOnClickListenerC0981bd f4049a;

    DialogInterfaceOnClickListenerC0982be(DialogInterfaceOnClickListenerC0981bd dialogInterfaceOnClickListenerC0981bd) {
        this.f4049a = dialogInterfaceOnClickListenerC0981bd;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
