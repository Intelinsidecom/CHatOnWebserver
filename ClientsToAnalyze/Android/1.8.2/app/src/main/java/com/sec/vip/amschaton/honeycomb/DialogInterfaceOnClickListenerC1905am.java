package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.am */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1905am implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f7034a;

    /* renamed from: b */
    final /* synthetic */ AMSMyWorksActivity f7035b;

    DialogInterfaceOnClickListenerC1905am(AMSMyWorksActivity aMSMyWorksActivity, String str) {
        this.f7035b = aMSMyWorksActivity;
        this.f7034a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7035b.m6674a(this.f7034a);
        dialogInterface.dismiss();
    }
}
