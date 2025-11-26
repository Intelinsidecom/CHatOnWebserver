package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.bb */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2340bb implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC2339ba f8793a;

    DialogInterfaceOnCancelListenerC2340bb(DialogC2339ba dialogC2339ba) {
        this.f8793a = dialogC2339ba;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f8793a.dismiss();
    }
}
