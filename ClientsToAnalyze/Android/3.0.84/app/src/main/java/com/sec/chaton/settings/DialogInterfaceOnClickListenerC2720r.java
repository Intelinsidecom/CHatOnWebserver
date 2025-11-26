package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.r */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2720r implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C2718p f10043a;

    DialogInterfaceOnClickListenerC2720r(C2718p c2718p) {
        this.f10043a = c2718p;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f10043a.f10041a.m8945b();
        dialogInterface.dismiss();
    }
}
