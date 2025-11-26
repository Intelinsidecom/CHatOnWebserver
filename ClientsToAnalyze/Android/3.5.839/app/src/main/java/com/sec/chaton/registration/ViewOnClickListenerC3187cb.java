package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.util.C4809aa;

/* compiled from: FragmentDisclaimerKR.java */
/* renamed from: com.sec.chaton.registration.cb */
/* loaded from: classes.dex */
class ViewOnClickListenerC3187cb implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerKR f11951a;

    ViewOnClickListenerC3187cb(FragmentDisclaimerKR fragmentDisclaimerKR) {
        this.f11951a = fragmentDisclaimerKR;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f11951a.f11629c = EnumC3183by.terms_and_condition;
        if (C4809aa.m18104a().m18121a("primary_admin_mobileweb_address", (String) null) == null) {
            this.f11951a.m12844a();
            this.f11951a.f11628b.m9552a();
        } else {
            this.f11951a.m12846b();
        }
    }
}
