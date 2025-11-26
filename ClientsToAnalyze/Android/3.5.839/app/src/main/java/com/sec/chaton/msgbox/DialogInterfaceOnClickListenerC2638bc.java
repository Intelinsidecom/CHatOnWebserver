package com.sec.chaton.msgbox;

import android.content.DialogInterface;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.bc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2638bc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f9487a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f9488b;

    DialogInterfaceOnClickListenerC2638bc(MsgboxFragment msgboxFragment, String str) {
        this.f9488b = msgboxFragment;
        this.f9487a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f9488b.m11052c(this.f9487a);
    }
}
