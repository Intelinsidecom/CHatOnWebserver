package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;

/* compiled from: ActivitySyncSignInPopup.java */
/* renamed from: com.sec.chaton.registration.p */
/* loaded from: classes.dex */
class ViewOnClickListenerC3309p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySyncSignInPopup f12086a;

    ViewOnClickListenerC3309p(ActivitySyncSignInPopup activitySyncSignInPopup) {
        this.f12086a = activitySyncSignInPopup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f12086a.f11568J) {
            this.f12086a.m13142k();
        } else {
            this.f12086a.startActivityForResult(new Intent(this.f12086a.f11562D, (Class<?>) ActivityRegist.class), 5);
        }
    }
}
