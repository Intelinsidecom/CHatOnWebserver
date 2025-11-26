package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: DatePickerWithCheckbox.java */
/* renamed from: com.sec.chaton.userprofile.w */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3154w implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC3152u f11436a;

    DialogInterfaceOnClickListenerC3154w(AlertDialogC3152u alertDialogC3152u) {
        this.f11436a = alertDialogC3152u;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f11436a.getWindow().setSoftInputMode(2);
        this.f11436a.f11431l.requestFocus();
    }
}
