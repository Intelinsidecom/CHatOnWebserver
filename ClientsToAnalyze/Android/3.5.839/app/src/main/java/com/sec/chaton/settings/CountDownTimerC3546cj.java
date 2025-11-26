package com.sec.chaton.settings;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.cj */
/* loaded from: classes.dex */
class CountDownTimerC3546cj extends CountDownTimer {

    /* renamed from: a */
    TextView f13034a;

    /* renamed from: b */
    final /* synthetic */ ActivityPasswordLockSet f13035b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountDownTimerC3546cj(ActivityPasswordLockSet activityPasswordLockSet, long j, long j2) {
        super(j, j2);
        this.f13035b = activityPasswordLockSet;
        this.f13034a = (TextView) this.f13035b.findViewById(R.id.description);
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.f13034a.setText(this.f13035b.getString(R.string.password_lock_timer_description, new Object[]{5, Integer.valueOf(((int) j) / 1000)}));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f13035b.m13495d(-1);
        this.f13035b.f12613z = 0;
        this.f13035b.f12603p = 0;
        long unused = ActivityPasswordLockSet.f12577J = -1L;
        this.f13035b.m13475b(true);
    }
}
