package com.sec.chaton.registration;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.registration.t */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0444t implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0416an f2957a;

    DialogInterfaceOnClickListenerC0444t(HandlerC0416an handlerC0416an) {
        this.f2957a = handlerC0416an;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f2957a.f2927a.f2824q = ProgressDialog.show(this.f2957a.f2927a.f2810c, null, this.f2957a.f2927a.getResources().getString(C0062R.string.please_wait), true);
        this.f2957a.f2927a.m3056f();
    }
}
