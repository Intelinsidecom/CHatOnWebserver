package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;

/* compiled from: AMSSamplesActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.br */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2022br implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f7306a;

    /* renamed from: b */
    final /* synthetic */ C2020bp f7307b;

    DialogInterfaceOnClickListenerC2022br(C2020bp c2020bp, String str) {
        this.f7307b = c2020bp;
        this.f7306a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7307b.f7304a.m7102a(this.f7306a);
        dialogInterface.dismiss();
    }
}
