package com.sec.chaton.sns.p115ui.facebook;

import com.sec.chaton.sns.p114b.InterfaceC4376ab;
import com.sec.chaton.util.C4904y;

/* compiled from: FacebookSubMenuFragment.java */
/* renamed from: com.sec.chaton.sns.ui.facebook.b */
/* loaded from: classes.dex */
class C4483b implements InterfaceC4376ab {

    /* renamed from: a */
    final /* synthetic */ FacebookSubMenuFragment f16175a;

    C4483b(FacebookSubMenuFragment facebookSubMenuFragment) {
        this.f16175a = facebookSubMenuFragment;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: a */
    public void mo9435a(int i) {
        this.f16175a.m16918e();
        this.f16175a.m16921h();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: a */
    public void mo9434a() {
        C4904y.m18639b("onComplete() \t- Login", FacebookSubMenuFragment.f16169g);
        this.f16175a.m16913a(this.f16175a.f16172j.m16651f());
        this.f16175a.m16920g();
        this.f16175a.m16994j();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: b */
    public void mo9436b() {
        this.f16175a.m16920g();
        this.f16175a.f16171i.finish();
    }
}
