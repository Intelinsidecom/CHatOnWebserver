package com.sec.chaton.registration;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.ds */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3231ds implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3228dp f11997a;

    DialogInterfaceOnClickListenerC3231ds(HandlerC3228dp handlerC3228dp) {
        this.f11997a = handlerC3228dp;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (EnumC3297gd.auto_register.equals(this.f11997a.f11994a.f11752ak)) {
            this.f11997a.f11994a.getActivity().setResult(4, new Intent());
        }
        this.f11997a.f11994a.getActivity().finish();
    }
}
