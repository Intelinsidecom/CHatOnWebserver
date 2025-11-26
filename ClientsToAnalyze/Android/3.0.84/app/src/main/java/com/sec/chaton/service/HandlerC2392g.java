package com.sec.chaton.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* compiled from: PushRegistrationService.java */
/* renamed from: com.sec.chaton.service.g */
/* loaded from: classes.dex */
class HandlerC2392g extends Handler {

    /* renamed from: a */
    final /* synthetic */ PushRegistrationService f8904a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2392g(PushRegistrationService pushRegistrationService, Looper looper) {
        super(looper);
        this.f8904a = pushRegistrationService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        String str = (String) message.obj;
        C3250y.m11453c("Push registration id: " + str, GlobalApplication.class.getSimpleName());
        GlobalApplication.f5511a = str;
        if (GlobalApplication.f5511a == null || GlobalApplication.f5511a.equals("")) {
            C3250y.m11450b("Push Registration ID is null. execute push registration.", PushRegistrationService.f8895a);
            this.f8904a.m8906b();
            return;
        }
        String strM10979a = C3159aa.m10962a().m10979a("get_version_push_reg_id", "");
        C3250y.m11450b("Last get version push registration id: " + strM10979a, PushRegistrationService.f8895a);
        if (strM10979a.equals(str)) {
            C3250y.m11450b("Last get version push id == current push id. don't execute GetVersion.", PushRegistrationService.f8895a);
            this.f8904a.f8896b = false;
            this.f8904a.stopSelf();
        } else {
            C3250y.m11450b("Last get version push registration id isn't equal. execute GetVersion.", PushRegistrationService.f8895a);
            this.f8904a.m8908c();
        }
    }
}
