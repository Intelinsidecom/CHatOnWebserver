package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;

/* compiled from: NewDisclaimerFragment.java */
/* renamed from: com.sec.chaton.registration.fq */
/* loaded from: classes.dex */
class ViewOnClickListenerC2274fq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NewDisclaimerFragment f8570a;

    ViewOnClickListenerC2274fq(NewDisclaimerFragment newDisclaimerFragment) {
        this.f8570a = newDisclaimerFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f8570a.f8372n, (Class<?>) ActivityWebView.class);
        intent.putExtra("PARAM_MENU", "TERMS_AND_CONDITION");
        this.f8570a.startActivity(intent);
    }
}
