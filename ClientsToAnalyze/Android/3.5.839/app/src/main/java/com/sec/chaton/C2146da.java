package com.sec.chaton;

import android.content.Intent;
import android.os.Handler;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2093az;
import com.sec.chaton.service.PushRegistrationService;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.InterfaceC4854bs;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.da */
/* loaded from: classes.dex */
class C2146da implements InterfaceC4854bs {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7774a;

    /* renamed from: b */
    private final Handler f7775b = new HandlerC2147db(this);

    C2146da(TabActivity tabActivity) {
        this.f7774a = tabActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC4854bs
    /* renamed from: a */
    public boolean mo7135a() {
        if (!C4809aa.m18104a().m18129b("uid")) {
            return false;
        }
        C2093az.m9337a().mo9080c(this.f7775b);
        if (GlobalApplication.f8355a == null) {
            C4904y.m18639b("Start PushRegistrationSerivce", GlobalApplication.class.getSimpleName());
            this.f7774a.startService(new Intent(this.f7774a.getApplicationContext(), (Class<?>) PushRegistrationService.class));
        }
        if (C2349a.m10301a("gcm_push_feature") && GlobalApplication.f8356b == null) {
            C4859bx.m18414i();
        }
        return true;
    }
}
