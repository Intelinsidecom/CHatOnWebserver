package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.b */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3479b implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSBgSelectionFragment f12844a;

    DialogInterfaceOnClickListenerC3479b(AMSBgSelectionFragment aMSBgSelectionFragment) {
        this.f12844a = aMSBgSelectionFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i <= 0) {
            this.f12844a.m12375c(1000);
        }
    }
}
