package com.sec.chaton.registration;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* compiled from: BackGroudDeleteAccount.java */
/* renamed from: com.sec.chaton.registration.bi */
/* loaded from: classes.dex */
class HandlerC2158bi extends Handler {

    /* renamed from: a */
    final /* synthetic */ BackGroudDeleteAccount f8439a;

    HandlerC2158bi(BackGroudDeleteAccount backGroudDeleteAccount) {
        this.f8439a = backGroudDeleteAccount;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (((Boolean) message.obj).booleanValue()) {
            C3250y.m11450b("Push deregistration is success. execute chaton deregistration.", BackGroudDeleteAccount.f8168h);
            if (this.f8439a.f8172d != null) {
                this.f8439a.f8173e = this.f8439a.f8172d.m5596a();
                return;
            }
            return;
        }
        C3250y.m11450b("Push deregistration is fail", BackGroudDeleteAccount.f8168h);
        C3159aa.m10963a("back_deregi_fail", (Boolean) true);
    }
}
