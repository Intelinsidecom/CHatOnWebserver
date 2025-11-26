package com.sec.chaton;

import android.content.Intent;
import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.C0192ae;
import com.sec.chaton.service.PushRegistrationService;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.InterfaceC1288ak;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.h */
/* loaded from: classes.dex */
class C0715h implements InterfaceC1288ak {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f2428a;

    /* renamed from: b */
    private Handler f2429b = new HandlerC1352v(this);

    C0715h(HomeActivity homeActivity) {
        this.f2428a = homeActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC1288ak
    /* renamed from: a */
    public boolean mo3044a() {
        if (!C1323bs.m4575a().contains("uid")) {
            return false;
        }
        C0192ae.m739a().mo744c(this.f2429b);
        if (GlobalApplication.f2407a == null) {
            C1341p.m4658b("Start PushRegistrationSerivce", GlobalApplication.class.getSimpleName());
            this.f2428a.startService(new Intent(this.f2428a.getApplicationContext(), (Class<?>) PushRegistrationService.class));
        }
        return true;
    }
}
