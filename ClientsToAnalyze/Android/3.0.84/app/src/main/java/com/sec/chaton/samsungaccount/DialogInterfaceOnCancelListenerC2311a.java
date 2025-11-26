package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: FragmentSamsungAccountLogin.java */
/* renamed from: com.sec.chaton.samsungaccount.a */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2311a implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSamsungAccountLogin f8734a;

    DialogInterfaceOnCancelListenerC2311a(FragmentSamsungAccountLogin fragmentSamsungAccountLogin) {
        this.f8734a = fragmentSamsungAccountLogin;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f8734a.f8647n.finish();
    }
}
