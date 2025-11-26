package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.view.View;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bu */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0998bu implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ long f4071a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f4072b;

    DialogInterfaceOnClickListenerC0998bu(ChatFragment chatFragment, long j) {
        this.f4072b = chatFragment;
        this.f4071a = j;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4072b.mo4966a((View) null, this.f4071a);
    }
}
