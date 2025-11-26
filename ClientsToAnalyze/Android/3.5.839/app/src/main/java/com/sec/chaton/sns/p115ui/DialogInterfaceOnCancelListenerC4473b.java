package com.sec.chaton.sns.p115ui;

import android.content.DialogInterface;

/* compiled from: OdnokDialog.java */
/* renamed from: com.sec.chaton.sns.ui.b */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC4473b implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC4446a f16158a;

    DialogInterfaceOnCancelListenerC4473b(DialogC4446a dialogC4446a) {
        this.f16158a = dialogC4446a;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f16158a.f16076i.stopLoading();
        this.f16158a.f16074g.mo2271a();
    }
}
