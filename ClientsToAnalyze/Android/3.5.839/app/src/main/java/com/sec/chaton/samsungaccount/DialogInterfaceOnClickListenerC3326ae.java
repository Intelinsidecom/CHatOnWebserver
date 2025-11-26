package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.ae */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3326ae implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AbstractMultiDeviceActivity f12246a;

    DialogInterfaceOnClickListenerC3326ae(AbstractMultiDeviceActivity abstractMultiDeviceActivity) {
        this.f12246a = abstractMultiDeviceActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f12246a.f12165s) {
            this.f12246a.finish();
        }
    }
}
