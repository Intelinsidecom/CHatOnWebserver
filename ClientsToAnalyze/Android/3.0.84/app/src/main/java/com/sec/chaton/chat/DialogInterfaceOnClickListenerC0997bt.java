package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bt */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0997bt implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f4068a;

    /* renamed from: b */
    final /* synthetic */ Intent f4069b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f4070c;

    DialogInterfaceOnClickListenerC0997bt(ChatFragment chatFragment, boolean z, Intent intent) {
        this.f4070c = chatFragment;
        this.f4068a = z;
        this.f4069b = intent;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f4068a) {
            this.f4070c.startActivity(this.f4069b);
        }
    }
}
