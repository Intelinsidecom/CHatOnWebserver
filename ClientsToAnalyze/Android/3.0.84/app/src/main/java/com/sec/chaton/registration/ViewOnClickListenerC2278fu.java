package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;

/* compiled from: NewDisclaimerFragment.java */
/* renamed from: com.sec.chaton.registration.fu */
/* loaded from: classes.dex */
class ViewOnClickListenerC2278fu implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NewDisclaimerFragment f8574a;

    ViewOnClickListenerC2278fu(NewDisclaimerFragment newDisclaimerFragment) {
        this.f8574a = newDisclaimerFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f8574a.f8372n, (Class<?>) ActivityWebView.class);
        intent.putExtra("PARAM_MENU", "ACCEPT_USE_DATA");
        this.f8574a.startActivity(intent);
    }
}
