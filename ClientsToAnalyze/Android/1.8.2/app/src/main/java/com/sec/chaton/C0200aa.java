package com.sec.chaton;

import android.content.Intent;
import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0620aj;
import com.sec.chaton.service.PushRegistrationService;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.InterfaceC1745ba;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.aa */
/* loaded from: classes.dex */
class C0200aa implements InterfaceC1745ba {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f724a;

    /* renamed from: b */
    private Handler f725b = new HandlerC0201ab(this);

    C0200aa(HomeActivity homeActivity) {
        this.f724a = homeActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC1745ba
    /* renamed from: a */
    public boolean mo1790a() {
        if (!C1789u.m6075a().contains("uid")) {
            return false;
        }
        C0620aj.m2804a().mo2705c(this.f725b);
        if (GlobalApplication.f2775a == null) {
            C1786r.m6061b("Start PushRegistrationSerivce", GlobalApplication.class.getSimpleName());
            this.f724a.startService(new Intent(this.f724a.getApplicationContext(), (Class<?>) PushRegistrationService.class));
        }
        return true;
    }
}
