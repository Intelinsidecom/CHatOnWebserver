package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.af */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1410af implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f5038a;

    /* renamed from: b */
    final /* synthetic */ C1455n f5039b;

    DialogInterfaceOnClickListenerC1410af(C1455n c1455n, String str) {
        this.f5039b = c1455n;
        this.f5038a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5039b.f5101a.m5129a(this.f5038a);
        dialogInterface.dismiss();
    }
}
