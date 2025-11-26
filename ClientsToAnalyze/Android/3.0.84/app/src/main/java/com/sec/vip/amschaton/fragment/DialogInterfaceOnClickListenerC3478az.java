package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.az */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3478az implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f12841a;

    /* renamed from: b */
    final /* synthetic */ int f12842b;

    /* renamed from: c */
    final /* synthetic */ AMSListFragment f12843c;

    DialogInterfaceOnClickListenerC3478az(AMSListFragment aMSListFragment, String str, int i) {
        this.f12843c = aMSListFragment;
        this.f12841a = str;
        this.f12842b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12843c.m12525a(this.f12841a, this.f12842b);
        dialogInterface.dismiss();
    }
}
