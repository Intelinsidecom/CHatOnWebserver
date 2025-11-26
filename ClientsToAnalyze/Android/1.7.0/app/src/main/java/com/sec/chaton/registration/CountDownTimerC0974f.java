package com.sec.chaton.registration;

import android.os.CountDownTimer;

/* compiled from: ActivityCountDown.java */
/* renamed from: com.sec.chaton.registration.f */
/* loaded from: classes.dex */
class CountDownTimerC0974f extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ ActivityCountDown f3371a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountDownTimerC0974f(ActivityCountDown activityCountDown, long j, long j2) {
        super(j, j2);
        this.f3371a = activityCountDown;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.f3371a.f3148a.setText("seconds remaining: " + (j / 1000));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f3371a.f3148a.setText("done!");
    }
}
