package com.sec.vip.amschaton.fragment;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.bu */
/* loaded from: classes.dex */
class ViewOnClickListenerC3500bu implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3499bt f12891a;

    ViewOnClickListenerC3500bu(C3499bt c3499bt) {
        this.f12891a = c3499bt;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof CheckBox) {
            CheckBox checkBox = (CheckBox) view;
            int id = checkBox.getId();
            if (this.f12891a.f12884b[id]) {
                checkBox.setChecked(false);
                this.f12891a.f12884b[id] = false;
            } else {
                checkBox.setChecked(true);
                this.f12891a.f12884b[id] = true;
            }
            this.f12891a.m12722c();
        }
    }
}
