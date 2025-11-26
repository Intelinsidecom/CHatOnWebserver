package com.sec.chaton.registration;

import android.os.CountDownTimer;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.da */
/* loaded from: classes.dex */
class CountDownTimerC2204da extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f8497a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountDownTimerC2204da(FragmentNonSelfSMS fragmentNonSelfSMS, long j, long j2) {
        super(j, j2);
        this.f8497a = fragmentNonSelfSMS;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.f8497a.f8220A.setText(FragmentNonSelfSMS.m8531a(j));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f8497a.m8567a();
    }
}
