package com.sec.chaton.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: PushRegistrationService.java */
/* renamed from: com.sec.chaton.service.c */
/* loaded from: classes.dex */
class HandlerC1217c extends Handler {

    /* renamed from: a */
    final /* synthetic */ PushRegistrationService f4440a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1217c(PushRegistrationService pushRegistrationService, Looper looper) {
        super(looper);
        this.f4440a = pushRegistrationService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        String str = (String) message.obj;
        C1786r.m6063c("Push registration id: " + str, GlobalApplication.class.getSimpleName());
        GlobalApplication.f2775a = str;
        if (GlobalApplication.f2775a == null || GlobalApplication.f2775a.equals("")) {
            C1786r.m6061b("Push Registration ID is null. execute push registration.", PushRegistrationService.f4435a);
            this.f4440a.m4471b();
            return;
        }
        String string = C1789u.m6075a().getString("get_version_push_reg_id", "");
        C1786r.m6061b("Last get version push registration id: " + string, PushRegistrationService.f4435a);
        if (string.equals(str)) {
            C1786r.m6061b("Last get version push id == current push id. don't execute GetVersion.", PushRegistrationService.f4435a);
            this.f4440a.f4436b = false;
            this.f4440a.stopSelf();
        } else {
            C1786r.m6061b("Last get version push registration id isn't equal. execute GetVersion.", PushRegistrationService.f4435a);
            this.f4440a.m4473c();
        }
    }
}
