package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.p025d.C1328f;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cb */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1006cb implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4080a;

    DialogInterfaceOnClickListenerC1006cb(ChatFragment chatFragment) {
        this.f4080a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4080a.m5021v();
        new C1328f(this.f4080a.f3522X).m5709b(this.f4080a.f3704s, 1);
    }
}
