package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.buddy.ae */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0081ae implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0132y f615a;

    DialogInterfaceOnClickListenerC0081ae(HandlerC0132y handlerC0132y) {
        this.f615a = handlerC0132y;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f615a.f718a.finish();
    }
}
