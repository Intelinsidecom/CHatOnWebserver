package com.sec.chaton.registration;

import android.os.CountDownTimer;
import com.sec.chaton.registration.ActivityNonSelfSMS;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.s */
/* loaded from: classes.dex */
class CountDownTimerC1206s extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS.NonSelfSMSFragment f4422a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountDownTimerC1206s(ActivityNonSelfSMS.NonSelfSMSFragment nonSelfSMSFragment, long j, long j2) {
        super(j, j2);
        this.f4422a = nonSelfSMSFragment;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.f4422a.f4177E.setText(ActivityNonSelfSMS.NonSelfSMSFragment.m4332a(j));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f4422a.m4367a();
    }
}
