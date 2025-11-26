package com.sec.chaton.registration;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* compiled from: BackGroudDeleteAccount.java */
/* renamed from: com.sec.chaton.registration.bj */
/* loaded from: classes.dex */
class HandlerC2159bj extends Handler {

    /* renamed from: a */
    final /* synthetic */ BackGroudDeleteAccount f8440a;

    HandlerC2159bj(BackGroudDeleteAccount backGroudDeleteAccount) {
        this.f8440a = backGroudDeleteAccount;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 202:
                if (c0267d != null && c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR && this.f8440a.f8173e != null && this.f8440a.f8173e.m5508i()) {
                    C3250y.m11450b("ChatON deregistration is success.", BackGroudDeleteAccount.f8168h);
                    if (!this.f8440a.f8175g) {
                        GlobalApplication.m6449a(this.f8440a.f8174f);
                        break;
                    } else {
                        C3159aa.m10963a("delete_account", (Boolean) true);
                        GlobalApplication.m6449a(this.f8440a.f8174f);
                        break;
                    }
                } else {
                    C3250y.m11450b("ChatON deregistration is fail.", BackGroudDeleteAccount.f8168h);
                    C3159aa.m10963a("back_deregi_fail", (Boolean) true);
                    break;
                }
        }
    }
}
