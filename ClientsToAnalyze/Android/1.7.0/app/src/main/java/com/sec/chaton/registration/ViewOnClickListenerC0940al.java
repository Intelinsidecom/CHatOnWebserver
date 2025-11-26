package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.al */
/* loaded from: classes.dex */
class ViewOnClickListenerC0940al implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f3327a;

    ViewOnClickListenerC0940al(AuthenticatorActivity authenticatorActivity) {
        this.f3327a = authenticatorActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f3327a, (Class<?>) ActivityWebView.class);
        intent.putExtra(FragmentWebView.PARAM_MENU, "PRIVACY_POLICY");
        this.f3327a.startActivity(intent);
    }
}
