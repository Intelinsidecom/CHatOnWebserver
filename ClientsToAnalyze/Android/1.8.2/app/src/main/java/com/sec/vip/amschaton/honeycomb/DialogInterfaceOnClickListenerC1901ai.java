package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.ai */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1901ai implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f7028a;

    /* renamed from: b */
    final /* synthetic */ C1897ae f7029b;

    DialogInterfaceOnClickListenerC1901ai(C1897ae c1897ae, String str) {
        this.f7029b = c1897ae;
        this.f7028a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7029b.f7023a.m6674a(this.f7028a);
        dialogInterface.dismiss();
    }
}
