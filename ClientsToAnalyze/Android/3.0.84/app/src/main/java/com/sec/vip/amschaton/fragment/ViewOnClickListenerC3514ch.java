package com.sec.vip.amschaton.fragment;

import android.view.View;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.ch */
/* loaded from: classes.dex */
class ViewOnClickListenerC3514ch implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ View f12911a;

    /* renamed from: b */
    final /* synthetic */ AMSStampSelectionFragment f12912b;

    ViewOnClickListenerC3514ch(AMSStampSelectionFragment aMSStampSelectionFragment, View view) {
        this.f12912b = aMSStampSelectionFragment;
        this.f12911a = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f12911a.setOnClickListener(null);
        this.f12912b.m12527a(null, false, false, false, false);
    }
}
