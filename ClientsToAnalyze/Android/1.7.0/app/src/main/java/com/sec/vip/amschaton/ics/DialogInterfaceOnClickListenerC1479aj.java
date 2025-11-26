package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;

/* compiled from: AMSSamplesActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.aj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1479aj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f5290a;

    /* renamed from: b */
    final /* synthetic */ C1534p f5291b;

    DialogInterfaceOnClickListenerC1479aj(C1534p c1534p, String str) {
        this.f5291b = c1534p;
        this.f5290a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5291b.f5362a.m5545a(this.f5290a);
        dialogInterface.dismiss();
    }
}
