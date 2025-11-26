package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.util.C4809aa;

/* compiled from: FragmentDisclaimerGlobal.java */
/* renamed from: com.sec.chaton.registration.bp */
/* loaded from: classes.dex */
class ViewOnClickListenerC3174bp implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerGlobal f11926a;

    ViewOnClickListenerC3174bp(FragmentDisclaimerGlobal fragmentDisclaimerGlobal) {
        this.f11926a = fragmentDisclaimerGlobal;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f11926a.f11629c = EnumC3183by.privacy_policy;
        if (C4809aa.m18104a().m18121a("primary_admin_mobileweb_address", (String) null) == null) {
            this.f11926a.m12844a();
            this.f11926a.f11628b.m9552a();
        } else {
            this.f11926a.m12846b();
        }
    }
}
