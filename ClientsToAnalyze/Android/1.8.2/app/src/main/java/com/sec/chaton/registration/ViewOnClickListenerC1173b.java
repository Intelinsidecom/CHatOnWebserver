package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;

/* compiled from: ActivityChatonVDisclaimer.java */
/* renamed from: com.sec.chaton.registration.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC1173b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChatonVDisclaimer f4375a;

    ViewOnClickListenerC1173b(ActivityChatonVDisclaimer activityChatonVDisclaimer) {
        this.f4375a = activityChatonVDisclaimer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4375a, (Class<?>) ActivityWebView.class);
        intent.putExtra(FragmentWebView.PARAM_MENU, "CHATONV_3RDPARTY_DISCLAIMER");
        this.f4375a.startActivity(intent);
    }
}
