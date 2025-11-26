package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: FragmentSamsungAccountLogin.java */
/* renamed from: com.sec.chaton.samsungaccount.k */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2363k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C2362j f8821a;

    DialogInterfaceOnClickListenerC2363k(C2362j c2362j) {
        this.f8821a = c2362j;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f8821a.f8819a.f8636c.canGoBack()) {
            this.f8821a.f8819a.f8636c.goBack();
        }
    }
}
