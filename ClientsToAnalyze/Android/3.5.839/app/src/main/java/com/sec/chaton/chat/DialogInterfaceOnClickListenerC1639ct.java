package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ct */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1639ct implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f6168a;

    /* renamed from: b */
    final /* synthetic */ Intent f6169b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f6170c;

    DialogInterfaceOnClickListenerC1639ct(ChatFragment chatFragment, boolean z, Intent intent) {
        this.f6170c = chatFragment;
        this.f6168a = z;
        this.f6169b = intent;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f6168a) {
            this.f6170c.startActivity(this.f6169b);
        }
    }
}
