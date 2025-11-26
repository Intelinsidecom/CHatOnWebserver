package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: RegisterSMSActivity.java */
/* renamed from: com.sec.chaton.registration.gb */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC3295gb implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ RegisterSMSActivity f12063a;

    DialogInterfaceOnCancelListenerC3295gb(RegisterSMSActivity registerSMSActivity) {
        this.f12063a = registerSMSActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f12063a.finish();
    }
}
