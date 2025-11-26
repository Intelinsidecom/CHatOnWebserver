package com.sec.vip.amschaton.honeycomb;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.as */
/* loaded from: classes.dex */
class ViewOnClickListenerC1911as implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1910ar f7045a;

    ViewOnClickListenerC1911as(C1910ar c1910ar) {
        this.f7045a = c1910ar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof CheckBox) {
            CheckBox checkBox = (CheckBox) view;
            int id = checkBox.getId();
            if (this.f7045a.f7042c[id]) {
                checkBox.setChecked(false);
                this.f7045a.f7042c[id] = false;
            } else {
                checkBox.setChecked(true);
                this.f7045a.f7042c[id] = true;
            }
            this.f7045a.m6849d();
        }
    }
}
