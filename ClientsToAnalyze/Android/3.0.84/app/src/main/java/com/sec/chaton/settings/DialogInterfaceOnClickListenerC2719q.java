package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.q */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2719q implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C2718p f10042a;

    DialogInterfaceOnClickListenerC2719q(C2718p c2718p) {
        this.f10042a = c2718p;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
