package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.util.C4809aa;

/* compiled from: FragmentDisclaimerKR.java */
/* renamed from: com.sec.chaton.registration.ce */
/* loaded from: classes.dex */
class ViewOnClickListenerC3190ce implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerKR f11954a;

    ViewOnClickListenerC3190ce(FragmentDisclaimerKR fragmentDisclaimerKR) {
        this.f11954a = fragmentDisclaimerKR;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f11954a.f11629c = EnumC3183by.push_marketing;
        if (C4809aa.m18104a().m18121a("primary_admin_mobileweb_address", (String) null) == null) {
            this.f11954a.m12844a();
            this.f11954a.f11628b.m9552a();
        } else {
            this.f11954a.m12846b();
        }
    }
}
