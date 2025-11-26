package com.sec.chaton.facebook;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.facebook.f */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0224f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FacebookMenuActivity f1855a;

    DialogInterfaceOnClickListenerC0224f(FacebookMenuActivity facebookMenuActivity) {
        this.f1855a = facebookMenuActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
