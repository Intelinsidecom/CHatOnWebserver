package com.sec.vip.amschaton.fragment;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.cx */
/* loaded from: classes.dex */
class ViewOnClickListenerC3530cx implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3529cw f12945a;

    ViewOnClickListenerC3530cx(C3529cw c3529cw) {
        this.f12945a = c3529cw;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof CheckBox) {
            CheckBox checkBox = (CheckBox) view;
            int id = checkBox.getId();
            if (this.f12945a.f12937b[id]) {
                checkBox.setChecked(false);
                this.f12945a.f12937b[id] = false;
            } else {
                checkBox.setChecked(true);
                this.f12945a.f12937b[id] = true;
            }
            this.f12945a.m12734c();
        }
    }
}
