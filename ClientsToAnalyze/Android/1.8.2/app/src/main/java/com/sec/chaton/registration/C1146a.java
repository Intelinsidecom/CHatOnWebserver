package com.sec.chaton.registration;

import android.widget.CompoundButton;

/* compiled from: ActivityChatonVDisclaimer.java */
/* renamed from: com.sec.chaton.registration.a */
/* loaded from: classes.dex */
class C1146a implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChatonVDisclaimer f4348a;

    C1146a(ActivityChatonVDisclaimer activityChatonVDisclaimer) {
        this.f4348a = activityChatonVDisclaimer;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f4348a.f4165i = true;
            this.f4348a.f4163d.setEnabled(true);
        } else {
            this.f4348a.f4165i = false;
            this.f4348a.f4163d.setEnabled(false);
        }
    }
}
