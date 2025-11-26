package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: FragmentSamsungAccountLogin.java */
/* renamed from: com.sec.chaton.samsungaccount.as */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3340as implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3339ar f12278a;

    DialogInterfaceOnClickListenerC3340as(C3339ar c3339ar) {
        this.f12278a = c3339ar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f12278a.f12276a.f12180c.canGoBack()) {
            this.f12278a.f12276a.f12180c.goBack();
        }
    }
}
