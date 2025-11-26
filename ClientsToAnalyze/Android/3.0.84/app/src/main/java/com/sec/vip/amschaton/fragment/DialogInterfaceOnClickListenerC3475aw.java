package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.aw */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3475aw implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSListFragment f12838a;

    DialogInterfaceOnClickListenerC3475aw(AMSListFragment aMSListFragment) {
        this.f12838a = aMSListFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f12838a.mo12415c();
    }
}
