package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.f */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3553f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSBgSelectionFragment f12983a;

    DialogInterfaceOnClickListenerC3553f(AMSBgSelectionFragment aMSBgSelectionFragment) {
        this.f12983a = aMSBgSelectionFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f12983a.mo12415c();
    }
}
