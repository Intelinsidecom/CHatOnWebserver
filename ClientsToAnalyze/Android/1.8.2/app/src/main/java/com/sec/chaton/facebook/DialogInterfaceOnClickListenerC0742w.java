package com.sec.chaton.facebook;

import android.content.DialogInterface;

/* compiled from: FacebookMenuActivity.java */
/* renamed from: com.sec.chaton.facebook.w */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0742w implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FacebookMenuActivity f2739a;

    DialogInterfaceOnClickListenerC0742w(FacebookMenuActivity facebookMenuActivity) {
        this.f2739a = facebookMenuActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f2739a.f2692a.m3222b(2);
        this.f2739a.showDialog(1);
    }
}
