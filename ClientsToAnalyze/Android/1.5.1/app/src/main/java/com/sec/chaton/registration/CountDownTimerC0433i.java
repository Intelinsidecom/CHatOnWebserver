package com.sec.chaton.registration;

import android.os.CountDownTimer;

/* renamed from: com.sec.chaton.registration.i */
/* loaded from: classes.dex */
class CountDownTimerC0433i extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ ActivityCountDown f2946a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountDownTimerC0433i(ActivityCountDown activityCountDown, long j, long j2) {
        super(j, j2);
        this.f2946a = activityCountDown;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f2946a.f2806a.setText("done!");
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.f2946a.f2806a.setText("seconds remaining: " + (j / 1000));
    }
}
