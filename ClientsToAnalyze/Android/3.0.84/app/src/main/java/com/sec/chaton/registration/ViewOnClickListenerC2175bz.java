package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;

/* compiled from: FragmentGlobalDisclaimer.java */
/* renamed from: com.sec.chaton.registration.bz */
/* loaded from: classes.dex */
class ViewOnClickListenerC2175bz implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentGlobalDisclaimer f8460a;

    ViewOnClickListenerC2175bz(FragmentGlobalDisclaimer fragmentGlobalDisclaimer) {
        this.f8460a = fragmentGlobalDisclaimer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f8460a.getActivity(), (Class<?>) ActivityWebView.class);
        intent.putExtra("PARAM_MENU", "PRIVACY_POLICY");
        this.f8460a.startActivity(intent);
    }
}
