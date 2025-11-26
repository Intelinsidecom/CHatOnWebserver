package com.sec.chaton.smsplugin.spam;

import android.content.DialogInterface;

/* compiled from: SetupSpamKeywordWriteForm.java */
/* renamed from: com.sec.chaton.smsplugin.spam.al */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC3981al implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ SetupSpamKeywordWriteForm f14422a;

    DialogInterfaceOnCancelListenerC3981al(SetupSpamKeywordWriteForm setupSpamKeywordWriteForm) {
        this.f14422a = setupSpamKeywordWriteForm;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f14422a.f14333h = 0L;
    }
}
