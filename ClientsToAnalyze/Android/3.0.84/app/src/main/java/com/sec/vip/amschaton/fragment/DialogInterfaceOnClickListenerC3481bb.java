package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.bb */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3481bb implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f12846a;

    /* renamed from: b */
    final /* synthetic */ int f12847b;

    /* renamed from: c */
    final /* synthetic */ AMSListFragment f12848c;

    DialogInterfaceOnClickListenerC3481bb(AMSListFragment aMSListFragment, String str, int i) {
        this.f12848c = aMSListFragment;
        this.f12846a = str;
        this.f12847b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12848c.m12525a(this.f12846a, this.f12847b);
        dialogInterface.dismiss();
    }
}
