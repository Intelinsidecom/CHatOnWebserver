package com.sec.vip.amschaton.fragment;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.u */
/* loaded from: classes.dex */
class ViewOnClickListenerC3568u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3567t f13014a;

    ViewOnClickListenerC3568u(C3567t c3567t) {
        this.f13014a = c3567t;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof CheckBox) {
            CheckBox checkBox = (CheckBox) view;
            int id = checkBox.getId();
            if (this.f13014a.f13008b[id]) {
                checkBox.setChecked(false);
                this.f13014a.f13008b[id] = false;
            } else {
                checkBox.setChecked(true);
                this.f13014a.f13008b[id] = true;
            }
            this.f13014a.m12752c();
        }
    }
}
