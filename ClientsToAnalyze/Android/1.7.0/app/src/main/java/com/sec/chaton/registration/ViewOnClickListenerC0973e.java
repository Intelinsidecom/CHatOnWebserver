package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;

/* compiled from: ActivityChatonVDownloads.java */
/* renamed from: com.sec.chaton.registration.e */
/* loaded from: classes.dex */
class ViewOnClickListenerC0973e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChatonVDownloads f3370a;

    ViewOnClickListenerC0973e(ActivityChatonVDownloads activityChatonVDownloads) {
        this.f3370a = activityChatonVDownloads;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3370a.startActivity(new Intent(this.f3370a, (Class<?>) ActivityChatonVDisclaimer.class));
    }
}
