package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.z */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2378z implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f8838a;

    DialogInterfaceOnClickListenerC2378z(MainActivity mainActivity) {
        this.f8838a = mainActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f8838a.f8693ao) {
            this.f8838a.finish();
        }
    }
}
