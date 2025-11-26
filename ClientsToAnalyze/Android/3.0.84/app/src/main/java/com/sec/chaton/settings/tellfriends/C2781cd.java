package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.util.C3250y;

/* compiled from: WeiboSubMenuFragment.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cd */
/* loaded from: classes.dex */
class C2781cd implements InterfaceC2729af {

    /* renamed from: a */
    final /* synthetic */ WeiboSubMenuFragment f10212a;

    C2781cd(WeiboSubMenuFragment weiboSubMenuFragment) {
        this.f10212a = weiboSubMenuFragment;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onError(int i) {
        this.f10212a.m9990g();
        this.f10212a.m9993j();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onComplete() {
        C3250y.m11450b("onComplete() \t- Login", WeiboSubMenuFragment.f10066g);
        this.f10212a.m9986a(this.f10212a.f10069j.mo9772b());
        this.f10212a.m9992i();
        this.f10212a.m9756c();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onCancelled() {
        this.f10212a.m9992i();
        if (this.f10212a.f10068i != null) {
            this.f10212a.f10068i.finish();
        }
    }
}
