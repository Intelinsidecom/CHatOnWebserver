package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: SpamConfirmDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.x */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0642x implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpamConfirmDialog f2862a;

    DialogInterfaceOnClickListenerC0642x(SpamConfirmDialog spamConfirmDialog) {
        this.f2862a = spamConfirmDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2862a.finish();
    }
}
