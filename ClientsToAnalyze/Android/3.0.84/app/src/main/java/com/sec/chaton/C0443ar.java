package com.sec.chaton;

import android.content.Intent;
import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1302ao;
import com.sec.chaton.service.PushRegistrationService;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.InterfaceC3204bs;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.ar */
/* loaded from: classes.dex */
class C0443ar implements InterfaceC3204bs {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1510a;

    /* renamed from: b */
    private Handler f1511b = new HandlerC0444as(this);

    C0443ar(TabActivity tabActivity) {
        this.f1510a = tabActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC3204bs
    /* renamed from: a */
    public boolean mo3063a() {
        if (!C3159aa.m10962a().m10987b("uid")) {
            return false;
        }
        C1302ao.m5594a().mo5482c(this.f1511b);
        if (GlobalApplication.f5511a == null) {
            C3250y.m11450b("Start PushRegistrationSerivce", GlobalApplication.class.getSimpleName());
            this.f1510a.startService(new Intent(this.f1510a.getApplicationContext(), (Class<?>) PushRegistrationService.class));
        }
        return true;
    }
}
