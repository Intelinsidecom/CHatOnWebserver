package com.sec.chaton.registration;

import android.os.CountDownTimer;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.cz */
/* loaded from: classes.dex */
class CountDownTimerC3211cz extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f11975a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountDownTimerC3211cz(FragmentNonSelfSMS fragmentNonSelfSMS, long j, long j2) {
        super(j, j2);
        this.f11975a = fragmentNonSelfSMS;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.f11975a.f11665B.setText(FragmentNonSelfSMS.m12862a(j));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f11975a.m12904a();
    }
}
