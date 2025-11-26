package com.sec.chaton.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: PushRegistrationService.java */
/* renamed from: com.sec.chaton.service.g */
/* loaded from: classes.dex */
class HandlerC3420g extends Handler {

    /* renamed from: a */
    final /* synthetic */ PushRegistrationService f12434a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC3420g(PushRegistrationService pushRegistrationService, Looper looper) {
        super(looper);
        this.f12434a = pushRegistrationService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        String str = (String) message.obj;
        C4904y.m18641c("Push registration id: " + str, GlobalApplication.class.getSimpleName());
        GlobalApplication.f8355a = str;
        if (GlobalApplication.f8355a == null || GlobalApplication.f8355a.equals("")) {
            C4904y.m18639b("Push Registration ID is null. execute push registration.", PushRegistrationService.f12425a);
            this.f12434a.m13292b();
            return;
        }
        String strM18121a = C4809aa.m18104a().m18121a("get_version_push_reg_id", "");
        C4904y.m18639b("Last get version push registration id: " + strM18121a, PushRegistrationService.f12425a);
        if (strM18121a.equals(str)) {
            C4904y.m18639b("Last get version push id == current push id. don't execute GetVersion.", PushRegistrationService.f12425a);
            this.f12434a.f12426b = false;
            this.f12434a.stopSelf();
        } else {
            C4904y.m18639b("Last get version push registration id isn't equal. execute GetVersion.", PushRegistrationService.f12425a);
            this.f12434a.m13294c();
        }
    }
}
