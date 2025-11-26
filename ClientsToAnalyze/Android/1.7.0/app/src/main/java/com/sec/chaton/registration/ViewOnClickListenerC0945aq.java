package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;

/* compiled from: ActivityDisclaimer.java */
/* renamed from: com.sec.chaton.registration.aq */
/* loaded from: classes.dex */
class ViewOnClickListenerC0945aq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityDisclaimer f3332a;

    ViewOnClickListenerC0945aq(ActivityDisclaimer activityDisclaimer) {
        this.f3332a = activityDisclaimer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f3332a, (Class<?>) ActivityWebView.class);
        intent.putExtra(FragmentWebView.PARAM_MENU, "TERMS_AND_CONDITION");
        this.f3332a.startActivity(intent);
    }
}
