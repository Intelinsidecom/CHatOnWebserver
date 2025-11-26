package com.sec.chaton.settings;

import android.os.CountDownTimer;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.ch */
/* loaded from: classes.dex */
class CountDownTimerC3544ch extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockSet f13032a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountDownTimerC3544ch(ActivityPasswordLockSet activityPasswordLockSet, long j, long j2) {
        super(j, j2);
        this.f13032a = activityPasswordLockSet;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f13032a.m13477c();
    }
}
