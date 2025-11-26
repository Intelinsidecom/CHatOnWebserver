package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.co */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1019co implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Intent f4101a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f4102b;

    DialogInterfaceOnClickListenerC1019co(ChatFragment chatFragment, Intent intent) {
        this.f4102b = chatFragment;
        this.f4101a = intent;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4102b.startActivity(this.f4101a);
    }
}
