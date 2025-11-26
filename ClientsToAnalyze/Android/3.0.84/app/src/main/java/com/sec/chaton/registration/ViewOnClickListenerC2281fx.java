package com.sec.chaton.registration;

import android.view.View;

/* compiled from: NewDisclaimerFragment.java */
/* renamed from: com.sec.chaton.registration.fx */
/* loaded from: classes.dex */
class ViewOnClickListenerC2281fx implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NewDisclaimerFragment f8577a;

    ViewOnClickListenerC2281fx(NewDisclaimerFragment newDisclaimerFragment) {
        this.f8577a = newDisclaimerFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f8577a.f8363e.isChecked()) {
            this.f8577a.f8363e.setChecked(false);
        } else {
            this.f8577a.f8363e.setChecked(true);
        }
        this.f8577a.m8654a();
    }
}
