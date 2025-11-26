package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;

/* compiled from: NewDisclaimerView.java */
/* renamed from: com.sec.chaton.registration.bl */
/* loaded from: classes.dex */
class ViewOnClickListenerC1185bl implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NewDisclaimerView f4395a;

    ViewOnClickListenerC1185bl(NewDisclaimerView newDisclaimerView) {
        this.f4395a = newDisclaimerView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4395a, (Class<?>) ActivityWebView.class);
        intent.putExtra(FragmentWebView.PARAM_MENU, "PRIVACY_POLICY");
        this.f4395a.startActivity(intent);
    }
}
