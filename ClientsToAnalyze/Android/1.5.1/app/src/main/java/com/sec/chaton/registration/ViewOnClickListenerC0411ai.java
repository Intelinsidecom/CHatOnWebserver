package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;

/* renamed from: com.sec.chaton.registration.ai */
/* loaded from: classes.dex */
class ViewOnClickListenerC0411ai implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f2919a;

    ViewOnClickListenerC0411ai(AuthenticatorActivity authenticatorActivity) {
        this.f2919a = authenticatorActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f2919a, (Class<?>) ActivityWebView.class);
        intent.putExtra("PARAM_MENU", "PRIVACY_POLICY");
        this.f2919a.startActivity(intent);
    }
}
