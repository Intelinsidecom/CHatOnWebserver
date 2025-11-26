package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ak */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1988ak implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f7261a;

    /* renamed from: b */
    final /* synthetic */ C1986ai f7262b;

    DialogInterfaceOnClickListenerC1988ak(C1986ai c1986ai, String str) {
        this.f7262b = c1986ai;
        this.f7261a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7262b.f7259a.m7005a(this.f7261a);
        dialogInterface.dismiss();
    }
}
