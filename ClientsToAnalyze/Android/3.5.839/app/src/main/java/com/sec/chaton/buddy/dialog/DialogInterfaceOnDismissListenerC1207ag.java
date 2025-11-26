package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: PhoneNumberSelectorDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.ag */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC1207ag implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ PhoneNumberSelectorDialog f4702a;

    DialogInterfaceOnDismissListenerC1207ag(PhoneNumberSelectorDialog phoneNumberSelectorDialog) {
        this.f4702a = phoneNumberSelectorDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f4702a.finish();
    }
}
