package com.sec.chaton.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;

/* compiled from: PushRegistrationService.java */
/* renamed from: com.sec.chaton.service.i */
/* loaded from: classes.dex */
class HandlerC2394i extends Handler {

    /* renamed from: a */
    final /* synthetic */ PushRegistrationService f8906a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2394i(PushRegistrationService pushRegistrationService, Looper looper) {
        super(looper);
        this.f8906a = pushRegistrationService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C0267d c0267d = (C0267d) message.obj;
        if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
            C3250y.m11442a("Get Version is failed, clear push registration id.", PushRegistrationService.f8895a);
            GlobalApplication.f5511a = null;
        }
        this.f8906a.f8896b = false;
        this.f8906a.stopSelf();
    }
}
