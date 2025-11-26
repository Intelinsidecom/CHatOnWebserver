package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.e */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3385e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AbstractMultiDeviceActivity f12345a;

    DialogInterfaceOnClickListenerC3385e(AbstractMultiDeviceActivity abstractMultiDeviceActivity) {
        this.f12345a = abstractMultiDeviceActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12345a.finish();
    }
}
