package com.sec.vip.amschaton.fragment;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.cb */
/* loaded from: classes.dex */
class ViewOnClickListenerC3508cb implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionFragment f12902a;

    ViewOnClickListenerC3508cb(AMSStampSelectionFragment aMSStampSelectionFragment) {
        this.f12902a = aMSStampSelectionFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof CheckBox) {
            this.f12902a.m12613c(((CheckBox) view).isChecked());
        } else {
            this.f12902a.f12755n.setChecked(!this.f12902a.f12755n.isChecked());
            this.f12902a.m12613c(this.f12902a.f12755n.isChecked());
        }
    }
}
