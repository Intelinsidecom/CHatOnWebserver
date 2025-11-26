package com.sec.chaton.facebook;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.facebook.c */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0221c implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f1849a;

    /* renamed from: b */
    final /* synthetic */ int f1850b;

    /* renamed from: c */
    final /* synthetic */ String f1851c;

    /* renamed from: d */
    final /* synthetic */ FacebookMenuActivity f1852d;

    DialogInterfaceOnClickListenerC0221c(FacebookMenuActivity facebookMenuActivity, int i, int i2, String str) {
        this.f1852d = facebookMenuActivity;
        this.f1849a = i;
        this.f1850b = i2;
        this.f1851c = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f1852d.f1839a.m2353a(this.f1849a, this.f1850b, this.f1851c);
    }
}
