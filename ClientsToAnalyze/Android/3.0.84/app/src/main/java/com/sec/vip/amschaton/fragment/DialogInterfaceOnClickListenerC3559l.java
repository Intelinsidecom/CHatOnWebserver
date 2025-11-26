package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.l */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3559l implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSBgSelectionFragment f12989a;

    DialogInterfaceOnClickListenerC3559l(AMSBgSelectionFragment aMSBgSelectionFragment) {
        this.f12989a = aMSBgSelectionFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2 = 1001;
        if (i == 1) {
            i2 = 1000;
        }
        this.f12989a.m12375c(i2);
    }
}
