package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.a */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC3321a implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AbstractMultiDeviceActivity f12239a;

    DialogInterfaceOnCancelListenerC3321a(AbstractMultiDeviceActivity abstractMultiDeviceActivity) {
        this.f12239a = abstractMultiDeviceActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (this.f12239a.f12149ao) {
            this.f12239a.finish();
        }
    }
}
