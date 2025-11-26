package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;

/* compiled from: ActivityChatonVDisclaimer.java */
/* renamed from: com.sec.chaton.registration.m */
/* loaded from: classes.dex */
class ViewOnClickListenerC0981m implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChatonVDisclaimer f3378a;

    ViewOnClickListenerC0981m(ActivityChatonVDisclaimer activityChatonVDisclaimer) {
        this.f3378a = activityChatonVDisclaimer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
        intent.putExtra("directcall", true);
        intent.putExtra("callerType", 1);
        intent.putExtra("GUID", "com.coolots.chaton");
        intent.addFlags(335544320);
        this.f3378a.startActivity(intent);
    }
}
