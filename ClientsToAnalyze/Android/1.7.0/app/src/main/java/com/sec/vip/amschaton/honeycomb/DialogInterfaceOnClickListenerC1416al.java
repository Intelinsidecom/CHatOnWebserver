package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;

/* compiled from: AMSSamplesActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.al */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1416al implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f5046a;

    /* renamed from: b */
    final /* synthetic */ C1429ay f5047b;

    DialogInterfaceOnClickListenerC1416al(C1429ay c1429ay, String str) {
        this.f5047b = c1429ay;
        this.f5046a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5047b.f5062a.m5218a(this.f5046a);
        dialogInterface.dismiss();
    }
}
