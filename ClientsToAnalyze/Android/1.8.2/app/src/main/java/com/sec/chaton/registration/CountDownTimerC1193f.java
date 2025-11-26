package com.sec.chaton.registration;

import android.os.CountDownTimer;

/* compiled from: ActivityCountDown.java */
/* renamed from: com.sec.chaton.registration.f */
/* loaded from: classes.dex */
class CountDownTimerC1193f extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ ActivityCountDown f4408a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountDownTimerC1193f(ActivityCountDown activityCountDown, long j, long j2) {
        super(j, j2);
        this.f4408a = activityCountDown;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.f4408a.f4169a.setText("seconds remaining: " + (j / 1000));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f4408a.f4169a.setText("done!");
    }
}
