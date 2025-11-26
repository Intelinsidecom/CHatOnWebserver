package com.sec.chaton.sns.p115ui.weibo;

import com.sec.chaton.sns.p114b.InterfaceC4376ab;
import com.sec.chaton.util.C4904y;

/* compiled from: WeiboSubMenuFragment.java */
/* renamed from: com.sec.chaton.sns.ui.weibo.b */
/* loaded from: classes.dex */
class C4520b implements InterfaceC4376ab {

    /* renamed from: a */
    final /* synthetic */ WeiboSubMenuFragment f16276a;

    C4520b(WeiboSubMenuFragment weiboSubMenuFragment) {
        this.f16276a = weiboSubMenuFragment;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: a */
    public void mo9435a(int i) {
        this.f16276a.m16918e();
        this.f16276a.m16921h();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: a */
    public void mo9434a() {
        C4904y.m18639b("onComplete() \t- Login", WeiboSubMenuFragment.f16271g);
        this.f16276a.m16913a(this.f16276a.f16274j.mo16647b());
        this.f16276a.m16920g();
        this.f16276a.m17112j();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: b */
    public void mo9436b() {
        this.f16276a.m16920g();
        if (this.f16276a.f16273i != null) {
            this.f16276a.f16273i.finish();
        }
    }
}
