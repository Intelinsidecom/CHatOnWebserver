package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;

/* compiled from: FragmentDisclaimerUpdate.java */
/* renamed from: com.sec.chaton.registration.cj */
/* loaded from: classes.dex */
class ViewOnClickListenerC3195cj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerUpdate f11959a;

    ViewOnClickListenerC3195cj(FragmentDisclaimerUpdate fragmentDisclaimerUpdate) {
        this.f11959a = fragmentDisclaimerUpdate;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f11959a.f11662e, (Class<?>) ActivityWebView.class);
        intent.putExtra(FragmentWebView.PARAM_MENU, "TERMS_AND_CONDITION");
        intent.putExtra(FragmentWebView.FROM_ABOUT_CHATON, true);
        this.f11959a.startActivity(intent);
    }
}
