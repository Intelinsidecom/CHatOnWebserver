package com.sec.vip.amschaton.fragment;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.h */
/* loaded from: classes.dex */
class ViewOnClickListenerC3555h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSBgSelectionFragment f12985a;

    ViewOnClickListenerC3555h(AMSBgSelectionFragment aMSBgSelectionFragment) {
        this.f12985a = aMSBgSelectionFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof CheckBox) {
            this.f12985a.m12367a(((CheckBox) view).isChecked());
        } else {
            this.f12985a.f12627A.setChecked(!this.f12985a.f12627A.isChecked());
            this.f12985a.m12367a(this.f12985a.f12627A.isChecked());
        }
    }
}
