package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.util.C1786r;

/* compiled from: FacebookSubMenuActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.e */
/* loaded from: classes.dex */
class C1453e implements InterfaceC1369ax {

    /* renamed from: a */
    final /* synthetic */ FacebookSubMenuActivity f5357a;

    C1453e(FacebookSubMenuActivity facebookSubMenuActivity) {
        this.f5357a = facebookSubMenuActivity;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1369ax
    /* renamed from: a */
    public void mo5103a() {
        C1786r.m6061b("onComplete() \t- Login", FacebookSubMenuActivity.f4931b);
        this.f5357a.f4937g.setText(this.f5357a.f4933c.m5125c());
        this.f5357a.m4786g();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1369ax
    /* renamed from: b */
    public void mo5104b() {
        C1786r.m6061b("onCancelled() \t- Login", FacebookSubMenuActivity.f4931b);
        this.f5357a.m4786g();
        this.f5357a.finish();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1369ax
    /* renamed from: c */
    public void mo5105c() {
        C1786r.m6054a("onError() \t- Login", FacebookSubMenuActivity.f4931b);
        this.f5357a.m4778c();
        this.f5357a.m4780d();
    }
}
