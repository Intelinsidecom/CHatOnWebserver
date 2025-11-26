package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: FragmentMultiDeviceView.java */
/* renamed from: com.sec.chaton.settings.du */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2657du implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC2655ds f9922a;

    DialogInterfaceOnClickListenerC2657du(ViewOnClickListenerC2655ds viewOnClickListenerC2655ds) {
        this.f9922a = viewOnClickListenerC2655ds;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
