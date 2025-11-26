package com.sec.chaton.registration;

import android.view.View;

/* compiled from: FragmentDisclaimerKR.java */
/* renamed from: com.sec.chaton.registration.ch */
/* loaded from: classes.dex */
class ViewOnClickListenerC3193ch implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerKR f11957a;

    ViewOnClickListenerC3193ch(FragmentDisclaimerKR fragmentDisclaimerKR) {
        this.f11957a = fragmentDisclaimerKR;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11957a.f11647m.isChecked()) {
            this.f11957a.f11647m.setChecked(false);
        } else {
            this.f11957a.f11647m.setChecked(true);
        }
    }
}
