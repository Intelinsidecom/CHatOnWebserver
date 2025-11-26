package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;

/* compiled from: NewDisclaimerView.java */
/* renamed from: com.sec.chaton.registration.bk */
/* loaded from: classes.dex */
class ViewOnClickListenerC1184bk implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NewDisclaimerView f4394a;

    ViewOnClickListenerC1184bk(NewDisclaimerView newDisclaimerView) {
        this.f4394a = newDisclaimerView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4394a, (Class<?>) ActivityWebView.class);
        intent.putExtra(FragmentWebView.PARAM_MENU, "ACCEPT_USE_DATA");
        this.f4394a.startActivity(intent);
    }
}
