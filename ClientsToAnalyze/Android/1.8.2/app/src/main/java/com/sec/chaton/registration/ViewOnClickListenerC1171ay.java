package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.ay */
/* loaded from: classes.dex */
class ViewOnClickListenerC1171ay implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f4373a;

    ViewOnClickListenerC1171ay(AuthenticatorActivity authenticatorActivity) {
        this.f4373a = authenticatorActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4373a, (Class<?>) ActivityWebView.class);
        intent.putExtra(FragmentWebView.PARAM_MENU, "PRIVACY_POLICY");
        this.f4373a.startActivity(intent);
    }
}
