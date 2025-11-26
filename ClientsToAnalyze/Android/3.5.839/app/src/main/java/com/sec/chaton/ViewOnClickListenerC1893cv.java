package com.sec.chaton;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.cv */
/* loaded from: classes.dex */
class ViewOnClickListenerC1893cv implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f7110a;

    /* renamed from: b */
    final /* synthetic */ TabActivity f7111b;

    ViewOnClickListenerC1893cv(TabActivity tabActivity, CheckBox checkBox) {
        this.f7111b = tabActivity;
        this.f7110a = checkBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f7110a.isChecked()) {
            this.f7110a.setChecked(false);
        } else {
            this.f7110a.setChecked(true);
        }
    }
}
