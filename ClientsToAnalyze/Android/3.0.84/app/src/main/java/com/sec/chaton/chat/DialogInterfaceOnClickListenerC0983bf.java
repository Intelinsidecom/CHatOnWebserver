package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.msgsend.C1756p;
import com.sec.chaton.p027e.C1454v;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bf */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0983bf implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f4050a;

    /* renamed from: b */
    final /* synthetic */ DialogInterfaceOnClickListenerC0981bd f4051b;

    DialogInterfaceOnClickListenerC0983bf(DialogInterfaceOnClickListenerC0981bd dialogInterfaceOnClickListenerC0981bd, String str) {
        this.f4051b = dialogInterfaceOnClickListenerC0981bd;
        this.f4050a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C1756p.m7231a(this.f4050a, this.f4051b.f4046b);
        this.f4051b.f4048d.f3551aa.startDelete(3, null, C1454v.f5393a, "_id='" + this.f4051b.f4046b + "'", null);
    }
}
