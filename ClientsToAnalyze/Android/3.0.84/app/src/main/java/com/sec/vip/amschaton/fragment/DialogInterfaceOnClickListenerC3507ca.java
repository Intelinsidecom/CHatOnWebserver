package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.ca */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3507ca implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionFragment f12901a;

    DialogInterfaceOnClickListenerC3507ca(AMSStampSelectionFragment aMSStampSelectionFragment) {
        this.f12901a = aMSStampSelectionFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f12901a.mo12415c();
    }
}
