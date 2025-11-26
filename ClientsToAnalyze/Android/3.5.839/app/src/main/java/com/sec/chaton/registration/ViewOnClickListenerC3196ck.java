package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2122ca;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: FragmentDisclaimerUpdate.java */
/* renamed from: com.sec.chaton.registration.ck */
/* loaded from: classes.dex */
class ViewOnClickListenerC3196ck implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerUpdate f11960a;

    ViewOnClickListenerC3196ck(FragmentDisclaimerUpdate fragmentDisclaimerUpdate) {
        this.f11960a = fragmentDisclaimerUpdate;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f11960a.f11659b = ProgressDialogC4926s.m18727a(this.f11960a.f11661d, null, this.f11960a.getResources().getString(R.string.dialog_provision_ing));
        new C2122ca(this.f11960a.f11658a).m9470a(this.f11960a.f11660c);
    }
}
