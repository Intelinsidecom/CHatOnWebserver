package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1499bc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f5320a;

    /* renamed from: b */
    final /* synthetic */ C1487ar f5321b;

    DialogInterfaceOnClickListenerC1499bc(C1487ar c1487ar, String str) {
        this.f5321b = c1487ar;
        this.f5320a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5321b.f5302a.m5443a(this.f5320a);
        dialogInterface.dismiss();
    }
}
