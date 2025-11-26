package com.sec.chaton.facebook;

import android.content.DialogInterface;

/* compiled from: FacebookMenuActivity.java */
/* renamed from: com.sec.chaton.facebook.f */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0691f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FacebookMenuActivity f2364a;

    DialogInterfaceOnClickListenerC0691f(FacebookMenuActivity facebookMenuActivity) {
        this.f2364a = facebookMenuActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f2364a.f2355a.m3084b(2);
        this.f2364a.showDialog(1);
    }
}
