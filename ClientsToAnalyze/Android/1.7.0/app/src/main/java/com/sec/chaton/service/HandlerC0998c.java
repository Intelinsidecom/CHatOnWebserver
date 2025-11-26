package com.sec.chaton.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* compiled from: PushRegistrationService.java */
/* renamed from: com.sec.chaton.service.c */
/* loaded from: classes.dex */
class HandlerC0998c extends Handler {

    /* renamed from: a */
    final /* synthetic */ PushRegistrationService f3401a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0998c(PushRegistrationService pushRegistrationService, Looper looper) {
        super(looper);
        this.f3401a = pushRegistrationService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        String str = (String) message.obj;
        C1341p.m4660c("Push registration id: " + str, GlobalApplication.class.getSimpleName());
        GlobalApplication.f2407a = str;
        if (GlobalApplication.f2407a == null || GlobalApplication.f2407a.equals("")) {
            C1341p.m4658b("Push Registration ID is null. execute push registration.", PushRegistrationService.f3396a);
            this.f3401a.m3772b();
            return;
        }
        String string = C1323bs.m4575a().getString("get_version_push_reg_id", "");
        C1341p.m4658b("Last get version push registration id: " + string, PushRegistrationService.f3396a);
        if (string.equals(str)) {
            C1341p.m4658b("Last get version push id == current push id. don't execute GetVersion.", PushRegistrationService.f3396a);
            this.f3401a.f3397b = false;
            this.f3401a.stopSelf();
        } else {
            C1341p.m4658b("Last get version push registration id isn't equal. execute GetVersion.", PushRegistrationService.f3396a);
            this.f3401a.m3774c();
        }
    }
}
