package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: PhoneNumberSelectorDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.w */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC0641w implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ PhoneNumberSelectorDialog f2861a;

    DialogInterfaceOnDismissListenerC0641w(PhoneNumberSelectorDialog phoneNumberSelectorDialog) {
        this.f2861a = phoneNumberSelectorDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f2861a.finish();
    }
}
