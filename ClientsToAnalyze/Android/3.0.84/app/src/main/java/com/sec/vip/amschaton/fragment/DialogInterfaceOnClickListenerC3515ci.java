package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.ci */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3515ci implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionFragment f12913a;

    DialogInterfaceOnClickListenerC3515ci(AMSStampSelectionFragment aMSStampSelectionFragment) {
        this.f12913a = aMSStampSelectionFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12913a.m12641k();
        dialogInterface.dismiss();
        this.f12913a.m12607b(false);
        this.f12913a.m12622e(2001);
        this.f12913a.getActivity().supportInvalidateOptionsMenu();
    }
}
