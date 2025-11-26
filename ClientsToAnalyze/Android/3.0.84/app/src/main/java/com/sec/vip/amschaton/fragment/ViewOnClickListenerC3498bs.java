package com.sec.vip.amschaton.fragment;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.bs */
/* loaded from: classes.dex */
class ViewOnClickListenerC3498bs implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f12881a;

    /* renamed from: b */
    final /* synthetic */ C3497br f12882b;

    ViewOnClickListenerC3498bs(C3497br c3497br, CheckBox checkBox) {
        this.f12882b = c3497br;
        this.f12881a = checkBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f12881a.setChecked(!this.f12881a.isChecked());
    }
}
