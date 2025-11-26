package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.t */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2372t implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2371s f8830a;

    DialogInterfaceOnClickListenerC2372t(HandlerC2371s handlerC2371s) {
        this.f8830a = handlerC2371s;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8830a.f8829a.finish();
    }
}
