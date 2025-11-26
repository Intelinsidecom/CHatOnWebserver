package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.content.res.Resources;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.i */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3389i implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3387g f12350a;

    DialogInterfaceOnClickListenerC3389i(HandlerC3387g handlerC3387g) {
        this.f12350a = handlerC3387g;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        this.f12350a.f12348a.m13147p();
        this.f12350a.f12348a.m13112g(false);
    }
}
