package com.sec.chaton.settings;

import com.sec.chaton.sns.p114b.C4410bi;
import com.sec.chaton.sns.p114b.InterfaceC4377ac;
import com.sec.chaton.util.C4809aa;

/* compiled from: ActivityManageAccounts.java */
/* renamed from: com.sec.chaton.settings.aw */
/* loaded from: classes.dex */
class C3505aw implements InterfaceC4377ac {

    /* renamed from: a */
    final /* synthetic */ HandlerC3504av f12993a;

    C3505aw(HandlerC3504av handlerC3504av) {
        this.f12993a = handlerC3504av;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4377ac
    /* renamed from: c */
    public void mo13847c() {
        this.f12993a.f12992a.m13404e();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4377ac
    /* renamed from: a */
    public void mo13845a() {
        this.f12993a.f12992a.m13404e();
        C4410bi.m16740a(this.f12993a.f12992a.f12526i);
        C4809aa.m18104a().m18123a("register_sns_type");
        this.f12993a.f12992a.finish();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4377ac
    /* renamed from: b */
    public void mo13846b() {
        this.f12993a.f12992a.m13404e();
    }
}
