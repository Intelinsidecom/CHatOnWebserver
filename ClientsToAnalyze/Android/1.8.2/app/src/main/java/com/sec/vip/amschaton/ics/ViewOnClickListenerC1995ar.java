package com.sec.vip.amschaton.ics;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ar */
/* loaded from: classes.dex */
class ViewOnClickListenerC1995ar implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1994aq f7273a;

    ViewOnClickListenerC1995ar(C1994aq c1994aq) {
        this.f7273a = c1994aq;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof CheckBox) {
            CheckBox checkBox = (CheckBox) view;
            int id = checkBox.getId();
            if (this.f7273a.f7270c[id]) {
                checkBox.setChecked(false);
                this.f7273a.f7270c[id] = false;
            } else {
                checkBox.setChecked(true);
                this.f7273a.f7270c[id] = true;
            }
            this.f7273a.m7162d();
        }
    }
}
