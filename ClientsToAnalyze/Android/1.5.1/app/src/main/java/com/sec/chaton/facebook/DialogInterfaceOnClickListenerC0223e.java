package com.sec.chaton.facebook;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.facebook.e */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0223e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FacebookMenuActivity f1854a;

    DialogInterfaceOnClickListenerC0223e(FacebookMenuActivity facebookMenuActivity) {
        this.f1854a = facebookMenuActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f1854a.f1839a.m2355b(2);
        this.f1854a.showDialog(1);
    }
}
