package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;

/* compiled from: AMSComposerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.ak */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3463ak implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerFragment f12823a;

    DialogInterfaceOnClickListenerC3463ak(AMSComposerFragment aMSComposerFragment) {
        this.f12823a = aMSComposerFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12823a.m12459e();
        this.f12823a.f12677Y = true;
        dialogInterface.dismiss();
        super/*com.sec.vip.amschaton.fragment.AMSFragment*/.mo12415c();
    }
}
