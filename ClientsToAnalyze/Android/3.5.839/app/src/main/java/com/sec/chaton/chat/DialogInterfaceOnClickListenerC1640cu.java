package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.view.View;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cu */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1640cu implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ long f6171a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f6172b;

    DialogInterfaceOnClickListenerC1640cu(ChatFragment chatFragment, long j) {
        this.f6172b = chatFragment;
        this.f6171a = j;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6172b.mo8223a((View) null, this.f6171a);
    }
}
