package com.sec.chaton.sns.p115ui;

import android.content.DialogInterface;

/* compiled from: OdnokDialog.java */
/* renamed from: com.sec.chaton.sns.ui.c */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC4478c implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC4446a f16163a;

    DialogInterfaceOnCancelListenerC4478c(DialogC4446a dialogC4446a) {
        this.f16163a = dialogC4446a;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f16163a.f16074g.mo2271a();
        this.f16163a.dismiss();
    }
}
