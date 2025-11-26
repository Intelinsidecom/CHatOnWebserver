package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;

/* compiled from: ActivityDisclaimer.java */
/* renamed from: com.sec.chaton.registration.ap */
/* loaded from: classes.dex */
class ViewOnClickListenerC0944ap implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityDisclaimer f3331a;

    ViewOnClickListenerC0944ap(ActivityDisclaimer activityDisclaimer) {
        this.f3331a = activityDisclaimer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f3331a, (Class<?>) ActivityWebView.class);
        intent.putExtra(FragmentWebView.PARAM_MENU, "PRIVACY_POLICY");
        this.f3331a.startActivity(intent);
    }
}
