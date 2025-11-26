package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dr */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1664dr implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6210a;

    /* renamed from: b */
    private boolean f6211b;

    public DialogInterfaceOnClickListenerC1664dr(ChatFragment chatFragment, boolean z) {
        this.f6210a = chatFragment;
        this.f6211b = z;
    }

    /* renamed from: a */
    public void m8499a(boolean z) {
        this.f6211b = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6210a.m8137e(this.f6211b);
    }
}
