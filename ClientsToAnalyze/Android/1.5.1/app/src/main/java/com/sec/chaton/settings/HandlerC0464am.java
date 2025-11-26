package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;

/* renamed from: com.sec.chaton.settings.am */
/* loaded from: classes.dex */
class HandlerC0464am extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityDeleteAccount f3156a;

    HandlerC0464am(ActivityDeleteAccount activityDeleteAccount) {
        this.f3156a = activityDeleteAccount;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f3156a.f2993h) {
            this.f3156a.f2992g.dismiss();
        }
        GlobalApplication.m2385b(this.f3156a.f2986a);
    }
}
