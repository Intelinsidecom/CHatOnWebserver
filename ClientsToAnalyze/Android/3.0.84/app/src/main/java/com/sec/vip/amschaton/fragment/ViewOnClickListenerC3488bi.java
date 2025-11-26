package com.sec.vip.amschaton.fragment;

import android.view.View;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.bi */
/* loaded from: classes.dex */
class ViewOnClickListenerC3488bi implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ View f12857a;

    /* renamed from: b */
    final /* synthetic */ AMSListFragment f12858b;

    ViewOnClickListenerC3488bi(AMSListFragment aMSListFragment, View view) {
        this.f12858b = aMSListFragment;
        this.f12857a = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f12857a.setOnClickListener(null);
        this.f12858b.m12527a(null, false, false, false, true);
    }
}
