package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.ax */
/* loaded from: classes.dex */
class ViewOnClickListenerC1170ax implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f4372a;

    ViewOnClickListenerC1170ax(AuthenticatorActivity authenticatorActivity) {
        this.f4372a = authenticatorActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4372a, (Class<?>) ActivityWebView.class);
        intent.putExtra(FragmentWebView.PARAM_MENU, "TERMS_AND_CONDITION");
        this.f4372a.startActivity(intent);
    }
}
