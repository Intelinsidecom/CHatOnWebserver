package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.util.C4809aa;

/* compiled from: FragmentDisclaimerKR.java */
/* renamed from: com.sec.chaton.registration.ca */
/* loaded from: classes.dex */
class ViewOnClickListenerC3186ca implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerKR f11950a;

    ViewOnClickListenerC3186ca(FragmentDisclaimerKR fragmentDisclaimerKR) {
        this.f11950a = fragmentDisclaimerKR;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11950a.f11630d) {
            this.f11950a.m12848d();
            C3892o.m15036j();
            C4809aa.m18104a().m18128b("provisioning_disclaimer_status", "DONE");
            this.f11950a.getActivity().setResult(-1, new Intent());
            this.f11950a.getActivity().finish();
            return;
        }
        this.f11950a.m12844a();
        this.f11950a.f11629c = EnumC3183by.nothing;
        this.f11950a.f11628b.m9552a();
    }
}
