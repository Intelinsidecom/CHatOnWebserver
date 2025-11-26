package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.util.C3250y;

/* compiled from: TwitterSubMenuFragment.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bk */
/* loaded from: classes.dex */
class C2761bk implements InterfaceC2729af {

    /* renamed from: a */
    final /* synthetic */ TwitterSubMenuFragment f10168a;

    C2761bk(TwitterSubMenuFragment twitterSubMenuFragment) {
        this.f10168a = twitterSubMenuFragment;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onError(int i) {
        this.f10168a.m9990g();
        this.f10168a.m9993j();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onComplete() {
        C3250y.m11450b("onComplete() \t- Login", TwitterSubMenuFragment.f10060g);
        this.f10168a.m9986a(this.f10168a.f10063j.mo9772b());
        this.f10168a.m9992i();
        this.f10168a.m9744c();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onCancelled() {
        this.f10168a.m9992i();
        if (this.f10168a.f10061h != null) {
            this.f10168a.f10061h.finish();
        }
    }
}
