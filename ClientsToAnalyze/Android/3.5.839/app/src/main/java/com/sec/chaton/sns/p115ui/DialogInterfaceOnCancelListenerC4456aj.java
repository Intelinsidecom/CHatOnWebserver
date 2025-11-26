package com.sec.chaton.sns.p115ui;

import android.content.DialogInterface;

/* compiled from: TwDialog.java */
/* renamed from: com.sec.chaton.sns.ui.aj */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC4456aj implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC4455ai f16114a;

    DialogInterfaceOnCancelListenerC4456aj(DialogC4455ai dialogC4455ai) {
        this.f16114a = dialogC4455ai;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f16114a.f16109l.stopLoading();
        this.f16114a.f16107j.mo2271a();
    }
}
