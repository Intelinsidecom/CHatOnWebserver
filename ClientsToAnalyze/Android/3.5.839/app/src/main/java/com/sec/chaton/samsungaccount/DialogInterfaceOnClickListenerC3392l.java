package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.l */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3392l implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3391k f12353a;

    DialogInterfaceOnClickListenerC3392l(HandlerC3391k handlerC3391k) {
        this.f12353a = handlerC3391k;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12353a.f12352a.finish();
    }
}
