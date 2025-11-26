package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: FragmentSamsungAccountLogin.java */
/* renamed from: com.sec.chaton.samsungaccount.ai */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC3330ai implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSamsungAccountLogin f12265a;

    DialogInterfaceOnCancelListenerC3330ai(FragmentSamsungAccountLogin fragmentSamsungAccountLogin) {
        this.f12265a = fragmentSamsungAccountLogin;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f12265a.f12190m.finish();
    }
}
