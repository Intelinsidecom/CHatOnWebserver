package com.sec.vip.amschaton.fragment;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.z */
/* loaded from: classes.dex */
class ViewOnClickListenerC3573z implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f13025a;

    /* renamed from: b */
    final /* synthetic */ C3572y f13026b;

    ViewOnClickListenerC3573z(C3572y c3572y, CheckBox checkBox) {
        this.f13026b = c3572y;
        this.f13025a = checkBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f13025a.setChecked(!this.f13025a.isChecked());
    }
}
