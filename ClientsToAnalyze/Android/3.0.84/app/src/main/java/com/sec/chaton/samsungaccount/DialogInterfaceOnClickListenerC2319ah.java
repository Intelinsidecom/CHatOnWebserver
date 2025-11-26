package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.ah */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2319ah implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2318ag f8741a;

    DialogInterfaceOnClickListenerC2319ah(HandlerC2318ag handlerC2318ag) {
        this.f8741a = handlerC2318ag;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
