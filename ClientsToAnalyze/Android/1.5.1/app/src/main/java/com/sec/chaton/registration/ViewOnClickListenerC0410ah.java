package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;

/* renamed from: com.sec.chaton.registration.ah */
/* loaded from: classes.dex */
class ViewOnClickListenerC0410ah implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f2918a;

    ViewOnClickListenerC0410ah(AuthenticatorActivity authenticatorActivity) {
        this.f2918a = authenticatorActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f2918a, (Class<?>) ActivityWebView.class);
        intent.putExtra("PARAM_MENU", "TERMS_AND_CONDITION");
        this.f2918a.startActivity(intent);
    }
}
