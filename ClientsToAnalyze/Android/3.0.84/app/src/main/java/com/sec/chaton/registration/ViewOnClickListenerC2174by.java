package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;

/* compiled from: FragmentGlobalDisclaimer.java */
/* renamed from: com.sec.chaton.registration.by */
/* loaded from: classes.dex */
class ViewOnClickListenerC2174by implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentGlobalDisclaimer f8459a;

    ViewOnClickListenerC2174by(FragmentGlobalDisclaimer fragmentGlobalDisclaimer) {
        this.f8459a = fragmentGlobalDisclaimer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f8459a.getActivity(), (Class<?>) ActivityWebView.class);
        intent.putExtra("PARAM_MENU", "TERMS_AND_CONDITION");
        this.f8459a.startActivity(intent);
    }
}
