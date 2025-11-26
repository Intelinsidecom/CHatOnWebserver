package com.sec.chaton.sns.p115ui;

import android.content.DialogInterface;

/* compiled from: OdnokDialog.java */
/* renamed from: com.sec.chaton.sns.ui.e */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4480e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC4446a f16165a;

    DialogInterfaceOnClickListenerC4480e(DialogC4446a dialogC4446a) {
        this.f16165a = dialogC4446a;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f16165a.dismiss();
        dialogInterface.dismiss();
        this.f16165a.f16074g.mo2271a();
    }
}
