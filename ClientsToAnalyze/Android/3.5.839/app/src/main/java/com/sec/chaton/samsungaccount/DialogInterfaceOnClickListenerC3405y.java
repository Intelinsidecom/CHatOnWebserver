package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.y */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3405y implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3404x f12366a;

    DialogInterfaceOnClickListenerC3405y(HandlerC3404x handlerC3404x) {
        this.f12366a = handlerC3404x;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12366a.f12365a.finish();
    }
}
