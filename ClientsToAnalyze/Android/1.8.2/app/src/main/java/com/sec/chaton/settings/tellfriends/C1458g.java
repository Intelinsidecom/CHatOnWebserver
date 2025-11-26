package com.sec.chaton.settings.tellfriends;

import android.webkit.CookieManager;
import com.sec.chaton.util.C1786r;

/* compiled from: FacebookSubMenuActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.g */
/* loaded from: classes.dex */
class C1458g implements InterfaceC1370ay {

    /* renamed from: a */
    final /* synthetic */ FacebookSubMenuActivity f5365a;

    C1458g(FacebookSubMenuActivity facebookSubMenuActivity) {
        this.f5365a = facebookSubMenuActivity;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1370ay
    /* renamed from: a */
    public void mo5106a() {
        C1786r.m6061b("onComplete() \t- Logout", FacebookSubMenuActivity.f4931b);
        CookieManager.getInstance().removeAllCookie();
        this.f5365a.m4786g();
        C1350ae.m5081a(this.f5365a.getApplicationContext()).m5084a(C1350ae.f5157a, false);
        this.f5365a.finish();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1370ay
    /* renamed from: b */
    public void mo5107b() {
        C1786r.m6061b("onCancelled() \t- Logout", FacebookSubMenuActivity.f4931b);
        this.f5365a.m4786g();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1370ay
    /* renamed from: c */
    public void mo5108c() {
        C1786r.m6054a("onError() \t- Logout", FacebookSubMenuActivity.f4931b);
        this.f5365a.m4778c();
        this.f5365a.m4780d();
    }
}
