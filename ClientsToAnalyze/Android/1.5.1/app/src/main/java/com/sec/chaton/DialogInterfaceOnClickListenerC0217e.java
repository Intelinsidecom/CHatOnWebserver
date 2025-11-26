package com.sec.chaton;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.e */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0217e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f1834a;

    DialogInterfaceOnClickListenerC0217e(HomeActivity homeActivity) {
        this.f1834a = homeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
