package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;

/* compiled from: ActivityChatonVDownloads.java */
/* renamed from: com.sec.chaton.registration.e */
/* loaded from: classes.dex */
class ViewOnClickListenerC1192e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChatonVDownloads f4407a;

    ViewOnClickListenerC1192e(ActivityChatonVDownloads activityChatonVDownloads) {
        this.f4407a = activityChatonVDownloads;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4407a.startActivity(new Intent(this.f4407a, (Class<?>) ActivityChatonVDisclaimer.class));
    }
}
