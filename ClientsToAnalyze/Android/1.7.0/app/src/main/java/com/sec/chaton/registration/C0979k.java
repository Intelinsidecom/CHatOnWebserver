package com.sec.chaton.registration;

import android.widget.CompoundButton;

/* compiled from: ActivityChatonVDisclaimer.java */
/* renamed from: com.sec.chaton.registration.k */
/* loaded from: classes.dex */
class C0979k implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChatonVDisclaimer f3376a;

    C0979k(ActivityChatonVDisclaimer activityChatonVDisclaimer) {
        this.f3376a = activityChatonVDisclaimer;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f3376a.f3144f = true;
            this.f3376a.f3142d.setEnabled(true);
        } else {
            this.f3376a.f3144f = false;
            this.f3376a.f3142d.setEnabled(false);
        }
    }
}
