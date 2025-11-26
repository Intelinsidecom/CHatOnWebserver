package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.al */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2323al implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2322ak f8745a;

    DialogInterfaceOnClickListenerC2323al(HandlerC2322ak handlerC2322ak) {
        this.f8745a = handlerC2322ak;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8745a.f8744a.finish();
    }
}
