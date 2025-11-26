package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;

/* compiled from: ActivityChatonVDisclaimer.java */
/* renamed from: com.sec.chaton.registration.d */
/* loaded from: classes.dex */
class ViewOnClickListenerC1191d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChatonVDisclaimer f4406a;

    ViewOnClickListenerC1191d(ActivityChatonVDisclaimer activityChatonVDisclaimer) {
        this.f4406a = activityChatonVDisclaimer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
        intent.putExtra("directcall", true);
        intent.putExtra("callerType", 1);
        intent.putExtra("GUID", "com.coolots.chaton");
        intent.addFlags(335544320);
        this.f4406a.startActivity(intent);
    }
}
