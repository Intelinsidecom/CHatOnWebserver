package com.sec.chaton.sns.p115ui;

import android.content.DialogInterface;

/* compiled from: RenrenDialog.java */
/* renamed from: com.sec.chaton.sns.ui.k */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC4489k implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC4487i f16192a;

    DialogInterfaceOnCancelListenerC4489k(DialogC4487i dialogC4487i) {
        this.f16192a = dialogC4487i;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f16192a.f16185d.mo2271a();
        this.f16192a.dismiss();
    }
}
