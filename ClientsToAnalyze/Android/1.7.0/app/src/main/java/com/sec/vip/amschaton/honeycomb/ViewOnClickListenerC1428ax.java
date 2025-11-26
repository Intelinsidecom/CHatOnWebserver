package com.sec.vip.amschaton.honeycomb;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.ax */
/* loaded from: classes.dex */
class ViewOnClickListenerC1428ax implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1452k f5061a;

    ViewOnClickListenerC1428ax(C1452k c1452k) {
        this.f5061a = c1452k;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof CheckBox) {
            CheckBox checkBox = (CheckBox) view;
            int id = checkBox.getId();
            if (this.f5061a.f5094c[id]) {
                checkBox.setChecked(false);
                this.f5061a.f5094c[id] = false;
            } else {
                checkBox.setChecked(true);
                this.f5061a.f5094c[id] = true;
            }
            this.f5061a.m5276d();
        }
    }
}
