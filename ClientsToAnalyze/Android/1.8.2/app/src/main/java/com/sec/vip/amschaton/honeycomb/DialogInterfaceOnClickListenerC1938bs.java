package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;

/* compiled from: AMSSamplesActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bs */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1938bs implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f7078a;

    /* renamed from: b */
    final /* synthetic */ C1936bq f7079b;

    DialogInterfaceOnClickListenerC1938bs(C1936bq c1936bq, String str) {
        this.f7079b = c1936bq;
        this.f7078a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7079b.f7076a.m6782a(this.f7078a);
        dialogInterface.dismiss();
    }
}
