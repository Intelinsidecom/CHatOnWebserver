package com.sec.chaton.registration;

import android.view.View;

/* compiled from: FragmentDisclaimerKR.java */
/* renamed from: com.sec.chaton.registration.ci */
/* loaded from: classes.dex */
class ViewOnClickListenerC3194ci implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerKR f11958a;

    ViewOnClickListenerC3194ci(FragmentDisclaimerKR fragmentDisclaimerKR) {
        this.f11958a = fragmentDisclaimerKR;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11958a.f11648n.isChecked()) {
            this.f11958a.f11648n.setChecked(false);
        } else {
            this.f11958a.f11648n.setChecked(true);
        }
    }
}
