package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: AutoRegiSamsungAccountActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.ah */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3329ah implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AutoRegiSamsungAccountActivity f12264a;

    DialogInterfaceOnClickListenerC3329ah(AutoRegiSamsungAccountActivity autoRegiSamsungAccountActivity) {
        this.f12264a = autoRegiSamsungAccountActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12264a.setResult(4);
        this.f12264a.finish();
    }
}
