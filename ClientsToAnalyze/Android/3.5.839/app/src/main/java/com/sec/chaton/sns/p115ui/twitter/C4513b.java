package com.sec.chaton.sns.p115ui.twitter;

import com.sec.chaton.sns.p114b.InterfaceC4376ab;
import com.sec.chaton.util.C4904y;

/* compiled from: TwitterSubMenuFragment.java */
/* renamed from: com.sec.chaton.sns.ui.twitter.b */
/* loaded from: classes.dex */
class C4513b implements InterfaceC4376ab {

    /* renamed from: a */
    final /* synthetic */ TwitterSubMenuFragment f16253a;

    C4513b(TwitterSubMenuFragment twitterSubMenuFragment) {
        this.f16253a = twitterSubMenuFragment;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: a */
    public void mo9435a(int i) {
        this.f16253a.m16918e();
        this.f16253a.m16921h();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: a */
    public void mo9434a() {
        C4904y.m18639b("onComplete() \t- Login", TwitterSubMenuFragment.f16248g);
        this.f16253a.m16913a(this.f16253a.f16251j.mo16647b());
        this.f16253a.m16920g();
        this.f16253a.m17080j();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: b */
    public void mo9436b() {
        this.f16253a.m16920g();
        if (this.f16253a.f16249h != null) {
            this.f16253a.f16249h.finish();
        }
    }
}
