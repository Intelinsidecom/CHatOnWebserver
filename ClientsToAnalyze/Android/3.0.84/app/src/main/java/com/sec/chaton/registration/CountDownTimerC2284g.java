package com.sec.chaton.registration;

import android.os.CountDownTimer;

/* compiled from: ActivityCountDown.java */
/* renamed from: com.sec.chaton.registration.g */
/* loaded from: classes.dex */
class CountDownTimerC2284g extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ ActivityCountDown f8580a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountDownTimerC2284g(ActivityCountDown activityCountDown, long j, long j2) {
        super(j, j2);
        this.f8580a = activityCountDown;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.f8580a.f8088a.setText("seconds remaining: " + (j / 1000));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f8580a.f8088a.setText("done!");
    }
}
