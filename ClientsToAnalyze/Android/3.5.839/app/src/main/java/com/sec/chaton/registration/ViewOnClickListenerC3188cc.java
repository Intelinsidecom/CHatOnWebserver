package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.util.C4809aa;

/* compiled from: FragmentDisclaimerKR.java */
/* renamed from: com.sec.chaton.registration.cc */
/* loaded from: classes.dex */
class ViewOnClickListenerC3188cc implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerKR f11952a;

    ViewOnClickListenerC3188cc(FragmentDisclaimerKR fragmentDisclaimerKR) {
        this.f11952a = fragmentDisclaimerKR;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f11952a.f11629c = EnumC3183by.accept_use_data;
        if (C4809aa.m18104a().m18121a("primary_admin_mobileweb_address", (String) null) == null) {
            this.f11952a.m12844a();
            this.f11952a.f11628b.m9552a();
        } else {
            this.f11952a.m12846b();
        }
    }
}
