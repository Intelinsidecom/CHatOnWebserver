package com.sec.chaton.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;

/* compiled from: PushRegistrationService.java */
/* renamed from: com.sec.chaton.service.i */
/* loaded from: classes.dex */
class HandlerC3422i extends Handler {

    /* renamed from: a */
    final /* synthetic */ PushRegistrationService f12436a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC3422i(PushRegistrationService pushRegistrationService, Looper looper) {
        super(looper);
        this.f12436a = pushRegistrationService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C0778b c0778b = (C0778b) message.obj;
        if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
            C4904y.m18634a("Get Version is failed, clear push registration id.", PushRegistrationService.f12425a);
            GlobalApplication.f8355a = null;
        }
        this.f12436a.f12426b = false;
        this.f12436a.stopSelf();
    }
}
