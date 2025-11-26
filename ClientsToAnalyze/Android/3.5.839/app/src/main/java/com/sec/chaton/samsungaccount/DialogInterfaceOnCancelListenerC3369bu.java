package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.bu */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC3369bu implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC3368bt f12326a;

    DialogInterfaceOnCancelListenerC3369bu(DialogC3368bt dialogC3368bt) {
        this.f12326a = dialogC3368bt;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f12326a.dismiss();
    }
}
