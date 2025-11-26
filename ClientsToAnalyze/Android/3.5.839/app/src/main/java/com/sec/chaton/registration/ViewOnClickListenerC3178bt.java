package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.util.C4904y;

/* compiled from: FragmentDisclaimerGlobal.java */
/* renamed from: com.sec.chaton.registration.bt */
/* loaded from: classes.dex */
class ViewOnClickListenerC3178bt implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerGlobal f11930a;

    ViewOnClickListenerC3178bt(FragmentDisclaimerGlobal fragmentDisclaimerGlobal) {
        this.f11930a = fragmentDisclaimerGlobal;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f11930a.f11631e++;
        if (C4904y.f17872b) {
            C4904y.m18639b("Touch Count : " + this.f11930a.f11631e, FragmentDisclaimerGlobal.f11626q);
        }
        if (this.f11930a.f11631e == 5 || this.f11930a.f11631e > 13) {
            new C3134ac(this.f11930a.getActivity(), null, null).m13037a(this.f11930a.f11631e);
        }
    }
}
