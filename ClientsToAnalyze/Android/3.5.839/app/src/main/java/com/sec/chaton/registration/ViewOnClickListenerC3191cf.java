package com.sec.chaton.registration;

import android.view.View;

/* compiled from: FragmentDisclaimerKR.java */
/* renamed from: com.sec.chaton.registration.cf */
/* loaded from: classes.dex */
class ViewOnClickListenerC3191cf implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerKR f11955a;

    ViewOnClickListenerC3191cf(FragmentDisclaimerKR fragmentDisclaimerKR) {
        this.f11955a = fragmentDisclaimerKR;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11955a.f11645k.isChecked()) {
            this.f11955a.f11645k.setChecked(false);
        } else {
            this.f11955a.f11645k.setChecked(true);
        }
        this.f11955a.m12854f();
    }
}
