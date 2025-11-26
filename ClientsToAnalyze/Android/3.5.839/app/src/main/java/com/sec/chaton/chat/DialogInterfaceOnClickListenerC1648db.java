package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.p055d.C2126g;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.db */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1648db implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6180a;

    DialogInterfaceOnClickListenerC1648db(ChatFragment chatFragment) {
        this.f6180a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6180a.m8274s();
        C2126g.m9476a(this.f6180a.f5540ag).m9482b(this.f6180a.f5752x, 1);
    }
}
