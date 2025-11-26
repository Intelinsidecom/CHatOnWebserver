package com.sec.vip.amschaton.fragment;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.bg */
/* loaded from: classes.dex */
class ViewOnClickListenerC3486bg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSListFragment f12855a;

    ViewOnClickListenerC3486bg(AMSListFragment aMSListFragment) {
        this.f12855a = aMSListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof CheckBox) {
            this.f12855a.m12558d(((CheckBox) view).isChecked());
            return;
        }
        this.f12855a.f12733o.setChecked(!this.f12855a.f12733o.isChecked());
        this.f12855a.m12558d(this.f12855a.f12733o.isChecked());
        this.f12855a.f12744z = this.f12855a.f12733o.isChecked();
    }
}
