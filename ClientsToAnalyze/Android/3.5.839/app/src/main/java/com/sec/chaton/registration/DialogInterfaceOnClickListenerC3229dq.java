package com.sec.chaton.registration;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3229dq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3228dp f11995a;

    DialogInterfaceOnClickListenerC3229dq(HandlerC3228dp handlerC3228dp) {
        this.f11995a = handlerC3228dp;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (EnumC3297gd.auto_register.equals(this.f11995a.f11994a.f11752ak)) {
            this.f11995a.f11994a.getActivity().setResult(4, new Intent());
        }
        this.f11995a.f11994a.getActivity().finish();
    }
}
