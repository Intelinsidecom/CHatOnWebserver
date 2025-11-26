package com.sec.chaton.facebook;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.facebook.d */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0222d implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FacebookMenuActivity f1853a;

    DialogInterfaceOnClickListenerC0222d(FacebookMenuActivity facebookMenuActivity) {
        this.f1853a = facebookMenuActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
