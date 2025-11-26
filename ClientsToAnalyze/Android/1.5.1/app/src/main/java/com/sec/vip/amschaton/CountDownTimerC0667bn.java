package com.sec.vip.amschaton;

import android.os.CountDownTimer;

/* renamed from: com.sec.vip.amschaton.bn */
/* loaded from: classes.dex */
class CountDownTimerC0667bn extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ BackgroundAudioRecordActivity f4287a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountDownTimerC0667bn(BackgroundAudioRecordActivity backgroundAudioRecordActivity, long j, long j2) {
        super(j, j2);
        this.f4287a = backgroundAudioRecordActivity;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        if (this.f4287a.f4096p) {
            this.f4287a.f4091B.setToNow();
            this.f4287a.f4092C = (int) ((this.f4287a.f4091B.toMillis(true) - this.f4287a.f4090A.toMillis(true)) / 1000);
            this.f4287a.f4105y.setProgress(this.f4287a.f4092C);
            this.f4287a.f4106z.setText(String.format("%d:%02d", Integer.valueOf(this.f4287a.f4092C / 60), Integer.valueOf(this.f4287a.f4092C % 60)));
        }
    }
}
