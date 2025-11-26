package com.sec.chaton.settings;

import android.os.CountDownTimer;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.bi */
/* loaded from: classes.dex */
class CountDownTimerC2448bi extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockSet f9308a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountDownTimerC2448bi(ActivityPasswordLockSet activityPasswordLockSet, long j, long j2) {
        super(j, j2);
        this.f9308a = activityPasswordLockSet;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f9308a.m9012c();
    }
}
