package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.util.C4809aa;

/* compiled from: FragmentDisclaimerGlobal.java */
/* renamed from: com.sec.chaton.registration.bl */
/* loaded from: classes.dex */
class ViewOnClickListenerC3170bl implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerGlobal f11922a;

    ViewOnClickListenerC3170bl(FragmentDisclaimerGlobal fragmentDisclaimerGlobal) {
        this.f11922a = fragmentDisclaimerGlobal;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f11922a.f11629c = EnumC3183by.terms_and_condition;
        if (C4809aa.m18104a().m18121a("primary_admin_mobileweb_address", (String) null) == null) {
            this.f11922a.m12844a();
            this.f11922a.f11628b.m9552a();
        } else {
            this.f11922a.m12846b();
        }
    }
}
