package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.v */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2374v implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2371s f8832a;

    DialogInterfaceOnClickListenerC2374v(HandlerC2371s handlerC2371s) {
        this.f8832a = handlerC2371s;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8832a.f8829a.finish();
    }
}
