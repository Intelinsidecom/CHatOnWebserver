package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.util.C4809aa;

/* compiled from: FragmentDisclaimerGlobal.java */
/* renamed from: com.sec.chaton.registration.bs */
/* loaded from: classes.dex */
class ViewOnClickListenerC3177bs implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerGlobal f11929a;

    ViewOnClickListenerC3177bs(FragmentDisclaimerGlobal fragmentDisclaimerGlobal) {
        this.f11929a = fragmentDisclaimerGlobal;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11929a.f11630d) {
            this.f11929a.m12848d();
            C3892o.m15036j();
            C4809aa.m18104a().m18128b("provisioning_disclaimer_status", "DONE");
            this.f11929a.getActivity().setResult(-1, new Intent());
            this.f11929a.getActivity().finish();
            return;
        }
        this.f11929a.m12844a();
        this.f11929a.f11629c = EnumC3183by.nothing;
        this.f11929a.f11628b.m9552a();
    }
}
