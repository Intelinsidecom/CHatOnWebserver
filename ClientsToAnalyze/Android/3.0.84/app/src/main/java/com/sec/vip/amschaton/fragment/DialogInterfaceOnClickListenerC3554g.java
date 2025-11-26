package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.g */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3554g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSBgSelectionFragment f12984a;

    DialogInterfaceOnClickListenerC3554g(AMSBgSelectionFragment aMSBgSelectionFragment) {
        this.f12984a = aMSBgSelectionFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12984a.m12413p();
        dialogInterface.dismiss();
        this.f12984a.m12381d(false);
        this.f12984a.m12380d(3001);
        this.f12984a.getActivity().supportInvalidateOptionsMenu();
    }
}
