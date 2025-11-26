package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.aa */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3322aa implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3404x f12240a;

    DialogInterfaceOnClickListenerC3322aa(HandlerC3404x handlerC3404x) {
        this.f12240a = handlerC3404x;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12240a.f12365a.finish();
    }
}
