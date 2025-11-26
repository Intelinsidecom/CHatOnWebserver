package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;

/* compiled from: NewDisclaimerFragment.java */
/* renamed from: com.sec.chaton.registration.fv */
/* loaded from: classes.dex */
class ViewOnClickListenerC2279fv implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NewDisclaimerFragment f8575a;

    ViewOnClickListenerC2279fv(NewDisclaimerFragment newDisclaimerFragment) {
        this.f8575a = newDisclaimerFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f8575a.f8372n, (Class<?>) ActivityWebView.class);
        intent.putExtra("PARAM_MENU", "PRIVACY_POLICY");
        this.f8575a.startActivity(intent);
    }
}
