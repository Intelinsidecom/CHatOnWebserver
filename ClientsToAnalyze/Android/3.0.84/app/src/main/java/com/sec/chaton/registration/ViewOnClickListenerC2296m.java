package com.sec.chaton.registration;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;

/* compiled from: ActivitySyncSignInPopup.java */
/* renamed from: com.sec.chaton.registration.m */
/* loaded from: classes.dex */
class ViewOnClickListenerC2296m implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySyncSignInPopup f8601a;

    ViewOnClickListenerC2296m(ActivitySyncSignInPopup activitySyncSignInPopup) {
        this.f8601a = activitySyncSignInPopup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        if (this.f8601a.f8130s) {
            this.f8601a.m8412d();
            this.f8601a.m8393a();
        } else {
            this.f8601a.startActivityForResult(new Intent(this.f8601a.f8118g, (Class<?>) ActivityRegist.class), 3);
        }
    }
}
