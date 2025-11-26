package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bv */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1614bv implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1612bt f6131a;

    DialogInterfaceOnClickListenerC1614bv(C1612bt c1612bt) {
        this.f6131a = c1612bt;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
