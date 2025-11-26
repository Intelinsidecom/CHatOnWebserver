package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bp */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0576bp implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1993a;

    DialogInterfaceOnClickListenerC0576bp(ChatFragment chatFragment) {
        this.f1993a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GlobalApplication.m3104b(GlobalApplication.m3100a());
    }
}
