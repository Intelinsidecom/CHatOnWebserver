package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3388h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3387g f12349a;

    DialogInterfaceOnClickListenerC3388h(HandlerC3387g handlerC3387g) {
        this.f12349a = handlerC3387g;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
