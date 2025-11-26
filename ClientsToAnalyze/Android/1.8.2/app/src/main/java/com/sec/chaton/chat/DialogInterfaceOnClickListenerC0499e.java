package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.e */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0499e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0497c f2095a;

    DialogInterfaceOnClickListenerC0499e(C0497c c0497c) {
        this.f2095a = c0497c;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
