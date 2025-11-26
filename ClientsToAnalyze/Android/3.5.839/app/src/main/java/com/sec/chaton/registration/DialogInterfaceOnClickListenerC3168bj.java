package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentConnectAccounts.java */
/* renamed from: com.sec.chaton.registration.bj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3168bj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentConnectAccounts f11920a;

    DialogInterfaceOnClickListenerC3168bj(FragmentConnectAccounts fragmentConnectAccounts) {
        this.f11920a = fragmentConnectAccounts;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f11920a.f11621h.finish();
    }
}
