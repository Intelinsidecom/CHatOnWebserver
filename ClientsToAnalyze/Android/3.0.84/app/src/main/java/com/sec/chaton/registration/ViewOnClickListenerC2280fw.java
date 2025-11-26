package com.sec.chaton.registration;

import android.view.View;

/* compiled from: NewDisclaimerFragment.java */
/* renamed from: com.sec.chaton.registration.fw */
/* loaded from: classes.dex */
class ViewOnClickListenerC2280fw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NewDisclaimerFragment f8576a;

    ViewOnClickListenerC2280fw(NewDisclaimerFragment newDisclaimerFragment) {
        this.f8576a = newDisclaimerFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f8576a.f8362d.isChecked()) {
            this.f8576a.f8362d.setChecked(false);
        } else {
            this.f8576a.f8362d.setChecked(true);
        }
        this.f8576a.m8654a();
    }
}
