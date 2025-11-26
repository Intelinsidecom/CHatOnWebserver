package com.sec.chaton.sns.p115ui;

import android.content.DialogInterface;

/* compiled from: RenrenDialog.java */
/* renamed from: com.sec.chaton.sns.ui.j */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC4488j implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC4487i f16191a;

    DialogInterfaceOnCancelListenerC4488j(DialogC4487i dialogC4487i) {
        this.f16191a = dialogC4487i;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f16191a.f16187f.stopLoading();
        this.f16191a.f16185d.mo2271a();
    }
}
