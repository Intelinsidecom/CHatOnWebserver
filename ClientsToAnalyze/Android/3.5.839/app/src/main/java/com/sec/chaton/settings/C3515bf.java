package com.sec.chaton.settings;

import com.sec.chaton.sns.p114b.InterfaceC4376ab;
import com.sec.chaton.util.C4904y;

/* compiled from: ActivityManageAccounts.java */
/* renamed from: com.sec.chaton.settings.bf */
/* loaded from: classes.dex */
class C3515bf implements InterfaceC4376ab {

    /* renamed from: a */
    final /* synthetic */ ActivityManageAccounts f13003a;

    C3515bf(ActivityManageAccounts activityManageAccounts) {
        this.f13003a = activityManageAccounts;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: a */
    public void mo9434a() {
        C4904y.m18639b("onComplete() \t- Login", this.f13003a.f12519b);
        this.f13003a.m13404e();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: b */
    public void mo9436b() {
        C4904y.m18639b("onCancelled() \t- Login", this.f13003a.f12519b);
        this.f13003a.m13404e();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: a */
    public void mo9435a(int i) {
        C4904y.m18634a("onError() \t- Login", this.f13003a.f12519b);
        this.f13003a.m13405f();
        this.f13003a.m13410h();
    }
}
