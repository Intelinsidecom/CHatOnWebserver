package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.view.View;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ab */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0460ab implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ long f1924a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f1925b;

    DialogInterfaceOnClickListenerC0460ab(ChatFragment chatFragment, long j) {
        this.f1925b = chatFragment;
        this.f1924a = j;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1925b.mo2590a((View) null, this.f1924a);
    }
}
