package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;

/* compiled from: NewDisclaimerView.java */
/* renamed from: com.sec.chaton.registration.bj */
/* loaded from: classes.dex */
class ViewOnClickListenerC1183bj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NewDisclaimerView f4393a;

    ViewOnClickListenerC1183bj(NewDisclaimerView newDisclaimerView) {
        this.f4393a = newDisclaimerView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4393a, (Class<?>) ActivityWebView.class);
        intent.putExtra(FragmentWebView.PARAM_MENU, "TERMS_AND_CONDITION");
        this.f4393a.startActivity(intent);
    }
}
