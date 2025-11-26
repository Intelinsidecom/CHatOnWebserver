package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.chat.translate.C1850c;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dn */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1660dn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1850c f6202a;

    /* renamed from: b */
    final /* synthetic */ C1729gb f6203b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f6204c;

    DialogInterfaceOnClickListenerC1660dn(ChatFragment chatFragment, C1850c c1850c, C1729gb c1729gb) {
        this.f6204c = chatFragment;
        this.f6202a = c1850c;
        this.f6203b = c1729gb;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f6204c.m7931a(this.f6202a, this.f6203b, ChatFragment.f5467dk, ChatFragment.f5468dl);
    }
}
