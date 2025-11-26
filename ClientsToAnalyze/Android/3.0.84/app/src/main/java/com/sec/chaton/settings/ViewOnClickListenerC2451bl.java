package com.sec.chaton.settings;

import android.view.View;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.bl */
/* loaded from: classes.dex */
class ViewOnClickListenerC2451bl implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockSet f9311a;

    ViewOnClickListenerC2451bl(ActivityPasswordLockSet activityPasswordLockSet) {
        this.f9311a = activityPasswordLockSet;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f9311a.f9022B.show();
        this.f9311a.f9023C = true;
    }
}
