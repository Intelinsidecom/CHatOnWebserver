package com.sec.chaton.settings;

import com.sec.chaton.sns.p114b.InterfaceC4376ab;
import com.sec.chaton.util.C4904y;

/* compiled from: ActivityManageAccounts.java */
/* renamed from: com.sec.chaton.settings.ba */
/* loaded from: classes.dex */
class C3510ba implements InterfaceC4376ab {

    /* renamed from: a */
    final /* synthetic */ C3508az f12998a;

    C3510ba(C3508az c3508az) {
        this.f12998a = c3508az;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: a */
    public void mo9435a(int i) {
        C4904y.m18639b("onError() \t- Login", this.f12998a.f12996a.f12519b);
        this.f12998a.f12996a.m13404e();
        this.f12998a.f12996a.m13410h();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: a */
    public void mo9434a() {
        C4904y.m18639b("onComplete() \t- Login", this.f12998a.f12996a.f12519b);
        this.f12998a.f12996a.m13400c();
        this.f12998a.f12996a.m13404e();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: b */
    public void mo9436b() {
        C4904y.m18639b("onCancelled() \t- Login", this.f12998a.f12996a.f12519b);
        this.f12998a.f12996a.m13404e();
    }
}
