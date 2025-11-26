package com.sec.chaton.registration;

import android.view.View;

/* compiled from: FragmentDisclaimerKR.java */
/* renamed from: com.sec.chaton.registration.cg */
/* loaded from: classes.dex */
class ViewOnClickListenerC3192cg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerKR f11956a;

    ViewOnClickListenerC3192cg(FragmentDisclaimerKR fragmentDisclaimerKR) {
        this.f11956a = fragmentDisclaimerKR;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11956a.f11646l.isChecked()) {
            this.f11956a.f11646l.setChecked(false);
        } else {
            this.f11956a.f11646l.setChecked(true);
        }
        this.f11956a.m12854f();
    }
}
