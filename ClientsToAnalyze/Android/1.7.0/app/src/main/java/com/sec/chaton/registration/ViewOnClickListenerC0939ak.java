package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.ak */
/* loaded from: classes.dex */
class ViewOnClickListenerC0939ak implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f3326a;

    ViewOnClickListenerC0939ak(AuthenticatorActivity authenticatorActivity) {
        this.f3326a = authenticatorActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f3326a, (Class<?>) ActivityWebView.class);
        intent.putExtra(FragmentWebView.PARAM_MENU, "TERMS_AND_CONDITION");
        this.f3326a.startActivity(intent);
    }
}
