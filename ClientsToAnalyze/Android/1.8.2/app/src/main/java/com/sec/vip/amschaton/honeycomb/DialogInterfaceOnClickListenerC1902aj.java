package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.aj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1902aj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f7030a;

    /* renamed from: b */
    final /* synthetic */ AMSMyWorksActivity f7031b;

    DialogInterfaceOnClickListenerC1902aj(AMSMyWorksActivity aMSMyWorksActivity, String str) {
        this.f7031b = aMSMyWorksActivity;
        this.f7030a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7031b.m6674a(this.f7030a);
        dialogInterface.dismiss();
    }
}
