package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: SpamConfirmDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.ah */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1208ah implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpamConfirmDialog f4703a;

    DialogInterfaceOnClickListenerC1208ah(SpamConfirmDialog spamConfirmDialog) {
        this.f4703a = spamConfirmDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4703a.finish();
    }
}
