package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.util.C4904y;

/* compiled from: FirstLauncherDialog.java */
/* renamed from: com.sec.chaton.registration.ad */
/* loaded from: classes.dex */
class ViewOnClickListenerC3135ad implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3134ac f11887a;

    ViewOnClickListenerC3135ad(C3134ac c3134ac) {
        this.f11887a = c3134ac;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C3134ac.m13019a(this.f11887a);
        if (C4904y.f17872b) {
            C4904y.m18639b("Touch Count : " + this.f11887a.f11879o, this.f11887a.f11886v);
        }
        if (this.f11887a.f11879o == 5 || this.f11887a.f11879o > 13) {
            this.f11887a.f11880p.show();
        }
    }
}
