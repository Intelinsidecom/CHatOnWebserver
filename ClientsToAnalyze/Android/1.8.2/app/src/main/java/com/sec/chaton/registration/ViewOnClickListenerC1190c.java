package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;

/* compiled from: ActivityChatonVDisclaimer.java */
/* renamed from: com.sec.chaton.registration.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC1190c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChatonVDisclaimer f4405a;

    ViewOnClickListenerC1190c(ActivityChatonVDisclaimer activityChatonVDisclaimer) {
        this.f4405a = activityChatonVDisclaimer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4405a, (Class<?>) ActivityWebView.class);
        intent.putExtra(FragmentWebView.PARAM_MENU, "SDS_TERMS_AND_CONDITION");
        this.f4405a.startActivity(intent);
    }
}
