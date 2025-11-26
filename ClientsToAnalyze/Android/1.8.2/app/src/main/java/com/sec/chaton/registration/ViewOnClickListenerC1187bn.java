package com.sec.chaton.registration;

import android.view.View;

/* compiled from: NewDisclaimerView.java */
/* renamed from: com.sec.chaton.registration.bn */
/* loaded from: classes.dex */
class ViewOnClickListenerC1187bn implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NewDisclaimerView f4397a;

    ViewOnClickListenerC1187bn(NewDisclaimerView newDisclaimerView) {
        this.f4397a = newDisclaimerView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4397a.f4329c.isChecked()) {
            this.f4397a.f4329c.setChecked(false);
        } else {
            this.f4397a.f4329c.setChecked(true);
        }
        this.f4397a.m4443a();
    }
}
