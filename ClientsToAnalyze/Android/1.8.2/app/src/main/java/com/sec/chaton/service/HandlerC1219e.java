package com.sec.chaton.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;

/* compiled from: PushRegistrationService.java */
/* renamed from: com.sec.chaton.service.e */
/* loaded from: classes.dex */
class HandlerC1219e extends Handler {

    /* renamed from: a */
    final /* synthetic */ PushRegistrationService f4442a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1219e(PushRegistrationService pushRegistrationService, Looper looper) {
        super(looper);
        this.f4442a = pushRegistrationService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C0101b c0101b = (C0101b) message.obj;
        if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
            C1786r.m6054a("Get Version is failed, clear push registration id.", PushRegistrationService.f4435a);
            GlobalApplication.f2775a = null;
        }
        this.f4442a.f4436b = false;
        this.f4442a.stopSelf();
    }
}
