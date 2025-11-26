package com.sec.chaton.smsplugin.spam;

import android.content.DialogInterface;

/* compiled from: SetupSpamNumberWriteForm.java */
/* renamed from: com.sec.chaton.smsplugin.spam.bl */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4008bl implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SetupSpamNumberWriteForm f14461a;

    DialogInterfaceOnClickListenerC4008bl(SetupSpamNumberWriteForm setupSpamNumberWriteForm) {
        this.f14461a = setupSpamNumberWriteForm;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
