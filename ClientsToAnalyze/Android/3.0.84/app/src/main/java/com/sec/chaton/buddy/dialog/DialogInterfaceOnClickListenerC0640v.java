package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: PhoneNumberSelectorDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.v */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0640v implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PhoneNumberSelectorDialog f2860a;

    DialogInterfaceOnClickListenerC0640v(PhoneNumberSelectorDialog phoneNumberSelectorDialog) {
        this.f2860a = phoneNumberSelectorDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Throwable {
        if (this.f2860a.f2778g != 1) {
            switch (i) {
                case 0:
                    this.f2860a.m4275c(this.f2860a.f2774c);
                    break;
                case 1:
                    this.f2860a.m4275c(this.f2860a.f2775d);
                    break;
                case 2:
                    this.f2860a.m4275c(this.f2860a.f2776e);
                    break;
                case 3:
                    this.f2860a.m4275c(this.f2860a.f2777f);
                    break;
            }
        } else {
            switch (i) {
                case 0:
                    this.f2860a.m4277a(this.f2860a.f2774c);
                    break;
                case 1:
                    this.f2860a.m4277a(this.f2860a.f2775d);
                    break;
                case 2:
                    this.f2860a.m4277a(this.f2860a.f2776e);
                    break;
                case 3:
                    this.f2860a.m4277a(this.f2860a.f2777f);
                    break;
            }
        }
        this.f2860a.finish();
    }
}
