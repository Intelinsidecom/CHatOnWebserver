package com.sec.chaton.registration;

import android.view.View;

/* compiled from: FragmentDisclaimerGlobal.java */
/* renamed from: com.sec.chaton.registration.bq */
/* loaded from: classes.dex */
class ViewOnClickListenerC3175bq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerGlobal f11927a;

    ViewOnClickListenerC3175bq(FragmentDisclaimerGlobal fragmentDisclaimerGlobal) {
        this.f11927a = fragmentDisclaimerGlobal;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11927a.f11637k.isChecked()) {
            this.f11927a.f11637k.setChecked(false);
        } else {
            this.f11927a.f11637k.setChecked(true);
        }
    }
}
