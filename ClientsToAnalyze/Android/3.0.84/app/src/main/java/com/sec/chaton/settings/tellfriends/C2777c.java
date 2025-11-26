package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.util.C3250y;

/* compiled from: FacebookSubMenuFragment.java */
/* renamed from: com.sec.chaton.settings.tellfriends.c */
/* loaded from: classes.dex */
class C2777c implements InterfaceC2729af {

    /* renamed from: a */
    final /* synthetic */ FacebookSubMenuFragment f10208a;

    C2777c(FacebookSubMenuFragment facebookSubMenuFragment) {
        this.f10208a = facebookSubMenuFragment;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onError(int i) {
        this.f10208a.m9990g();
        this.f10208a.m9993j();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onComplete() {
        C3250y.m11450b("onComplete() \t- Login", FacebookSubMenuFragment.f10047g);
        this.f10208a.m9986a(this.f10208a.f10050j.m9798e());
        this.f10208a.m9992i();
        this.f10208a.m9720c();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onCancelled() {
        this.f10208a.m9992i();
        this.f10208a.f10049i.finish();
    }
}
