package com.sec.chaton.sns.p115ui;

import android.content.DialogInterface;

/* compiled from: TwDialog.java */
/* renamed from: com.sec.chaton.sns.ui.ak */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC4457ak implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC4455ai f16115a;

    DialogInterfaceOnCancelListenerC4457ak(DialogC4455ai dialogC4455ai) {
        this.f16115a = dialogC4455ai;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f16115a.f16107j.mo2271a();
        this.f16115a.dismiss();
    }
}
