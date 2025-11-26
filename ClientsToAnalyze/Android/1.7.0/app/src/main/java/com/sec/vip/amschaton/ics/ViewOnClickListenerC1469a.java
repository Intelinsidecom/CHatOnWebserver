package com.sec.vip.amschaton.ics;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.a */
/* loaded from: classes.dex */
class ViewOnClickListenerC1469a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1492aw f5276a;

    ViewOnClickListenerC1469a(C1492aw c1492aw) {
        this.f5276a = c1492aw;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof CheckBox) {
            CheckBox checkBox = (CheckBox) view;
            int id = checkBox.getId();
            if (this.f5276a.f5309c[id]) {
                checkBox.setChecked(false);
                this.f5276a.f5309c[id] = false;
            } else {
                checkBox.setChecked(true);
                this.f5276a.f5309c[id] = true;
            }
            this.f5276a.m5604d();
        }
    }
}
