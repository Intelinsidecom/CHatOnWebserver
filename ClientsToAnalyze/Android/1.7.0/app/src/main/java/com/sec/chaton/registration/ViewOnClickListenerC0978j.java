package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;

/* compiled from: ActivityChatonVDisclaimer.java */
/* renamed from: com.sec.chaton.registration.j */
/* loaded from: classes.dex */
class ViewOnClickListenerC0978j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChatonVDisclaimer f3375a;

    ViewOnClickListenerC0978j(ActivityChatonVDisclaimer activityChatonVDisclaimer) {
        this.f3375a = activityChatonVDisclaimer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f3375a, (Class<?>) ActivityWebView.class);
        intent.putExtra(FragmentWebView.PARAM_MENU, "CHATONV_3RDPARTY_DISCLAIMER");
        this.f3375a.startActivity(intent);
    }
}
