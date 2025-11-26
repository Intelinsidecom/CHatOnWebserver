package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;

/* compiled from: ActivityChatonVDisclaimer.java */
/* renamed from: com.sec.chaton.registration.l */
/* loaded from: classes.dex */
class ViewOnClickListenerC0980l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChatonVDisclaimer f3377a;

    ViewOnClickListenerC0980l(ActivityChatonVDisclaimer activityChatonVDisclaimer) {
        this.f3377a = activityChatonVDisclaimer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f3377a, (Class<?>) ActivityWebView.class);
        intent.putExtra(FragmentWebView.PARAM_MENU, "SDS_TERMS_AND_CONDITION");
        this.f3377a.startActivity(intent);
    }
}
