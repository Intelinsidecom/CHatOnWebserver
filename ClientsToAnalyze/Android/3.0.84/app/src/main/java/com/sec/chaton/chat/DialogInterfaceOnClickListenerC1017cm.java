package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.chat.p024b.C0952c;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cm */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1017cm implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0952c f4097a;

    /* renamed from: b */
    final /* synthetic */ C1070el f4098b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f4099c;

    DialogInterfaceOnClickListenerC1017cm(ChatFragment chatFragment, C0952c c0952c, C1070el c1070el) {
        this.f4099c = chatFragment;
        this.f4097a = c0952c;
        this.f4098b = c1070el;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f4099c.m4762a(this.f4097a, this.f4098b, ChatFragment.f3485cP, ChatFragment.f3486cQ);
    }
}
