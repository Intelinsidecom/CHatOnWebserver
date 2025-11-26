package com.sec.vip.amschaton.fragment;

import android.view.View;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.a */
/* loaded from: classes.dex */
class ViewOnClickListenerC3452a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ View f12811a;

    /* renamed from: b */
    final /* synthetic */ AMSBgSelectionFragment f12812b;

    ViewOnClickListenerC3452a(AMSBgSelectionFragment aMSBgSelectionFragment, View view) {
        this.f12812b = aMSBgSelectionFragment;
        this.f12811a = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f12811a.setOnClickListener(null);
        this.f12812b.m12527a(null, false, false, false, false);
    }
}
