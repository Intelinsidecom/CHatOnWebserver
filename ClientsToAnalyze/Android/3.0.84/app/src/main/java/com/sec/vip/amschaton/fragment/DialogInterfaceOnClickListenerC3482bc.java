package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.bc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3482bc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSListFragment f12849a;

    DialogInterfaceOnClickListenerC3482bc(AMSListFragment aMSListFragment) {
        this.f12849a = aMSListFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12849a.m12546b();
        dialogInterface.dismiss();
        this.f12849a.m12542a(false);
        this.f12849a.m12551c(2001);
        this.f12849a.getActivity().supportInvalidateOptionsMenu();
    }
}
