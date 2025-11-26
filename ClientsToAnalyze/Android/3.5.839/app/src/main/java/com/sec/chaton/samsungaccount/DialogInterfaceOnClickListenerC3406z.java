package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.content.res.Resources;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.z */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3406z implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3404x f12367a;

    DialogInterfaceOnClickListenerC3406z(HandlerC3404x handlerC3404x) {
        this.f12367a = handlerC3404x;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        this.f12367a.f12365a.f12138ad = true;
        if (!this.f12367a.f12365a.f12137ac) {
            this.f12367a.f12365a.m13112g(true);
        } else {
            this.f12367a.f12365a.m13142k();
        }
    }
}
