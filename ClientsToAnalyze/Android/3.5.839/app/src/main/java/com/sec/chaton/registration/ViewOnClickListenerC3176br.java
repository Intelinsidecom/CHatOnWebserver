package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.util.C4809aa;

/* compiled from: FragmentDisclaimerGlobal.java */
/* renamed from: com.sec.chaton.registration.br */
/* loaded from: classes.dex */
class ViewOnClickListenerC3176br implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerGlobal f11928a;

    ViewOnClickListenerC3176br(FragmentDisclaimerGlobal fragmentDisclaimerGlobal) {
        this.f11928a = fragmentDisclaimerGlobal;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f11928a.f11629c = EnumC3183by.push_marketing;
        if (C4809aa.m18104a().m18121a("primary_admin_mobileweb_address", (String) null) == null) {
            this.f11928a.m12844a();
            this.f11928a.f11628b.m9552a();
        } else {
            this.f11928a.m12846b();
        }
    }
}
