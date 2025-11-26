package com.sec.vip.amschaton.fragment;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.dc */
/* loaded from: classes.dex */
class ViewOnClickListenerC3536dc implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f12961a;

    /* renamed from: b */
    final /* synthetic */ C3535db f12962b;

    ViewOnClickListenerC3536dc(C3535db c3535db, CheckBox checkBox) {
        this.f12962b = c3535db;
        this.f12961a = checkBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f12961a.setChecked(!this.f12961a.isChecked());
    }
}
