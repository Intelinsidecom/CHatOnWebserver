package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: FragmentMultiDeviceView.java */
/* renamed from: com.sec.chaton.settings.el */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3602el implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC3600ej f13128a;

    DialogInterfaceOnClickListenerC3602el(ViewOnClickListenerC3600ej viewOnClickListenerC3600ej) {
        this.f13128a = viewOnClickListenerC3600ej;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
