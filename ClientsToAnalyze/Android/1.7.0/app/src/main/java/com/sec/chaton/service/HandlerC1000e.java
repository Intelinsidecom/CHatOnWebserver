package com.sec.chaton.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.util.C1341p;

/* compiled from: PushRegistrationService.java */
/* renamed from: com.sec.chaton.service.e */
/* loaded from: classes.dex */
class HandlerC1000e extends Handler {

    /* renamed from: a */
    final /* synthetic */ PushRegistrationService f3403a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1000e(PushRegistrationService pushRegistrationService, Looper looper) {
        super(looper);
        this.f3403a = pushRegistrationService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C0259g c0259g = (C0259g) message.obj;
        if (!c0259g.m927a() || c0259g.m928b() == EnumC0518y.ERROR) {
            C1341p.m4651a("Get Version is failed, clear push registration id.", PushRegistrationService.f3396a);
            GlobalApplication.f2407a = null;
        }
        this.f3403a.f3397b = false;
        this.f3403a.stopSelf();
    }
}
