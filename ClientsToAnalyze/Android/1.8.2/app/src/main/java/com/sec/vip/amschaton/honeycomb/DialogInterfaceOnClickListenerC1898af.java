package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.af */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1898af implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f7024a;

    /* renamed from: b */
    final /* synthetic */ C1897ae f7025b;

    DialogInterfaceOnClickListenerC1898af(C1897ae c1897ae, String str) {
        this.f7025b = c1897ae;
        this.f7024a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7025b.f7023a.m6674a(this.f7024a);
        dialogInterface.dismiss();
    }
}
