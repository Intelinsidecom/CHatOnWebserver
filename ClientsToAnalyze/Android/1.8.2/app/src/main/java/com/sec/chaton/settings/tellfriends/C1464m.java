package com.sec.chaton.settings.tellfriends;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.sec.chaton.util.C1786r;

/* compiled from: InviteFacebookActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.m */
/* loaded from: classes.dex */
class C1464m implements InterfaceC1370ay {

    /* renamed from: a */
    final /* synthetic */ InviteFacebookActivity f5372a;

    C1464m(InviteFacebookActivity inviteFacebookActivity) {
        this.f5372a = inviteFacebookActivity;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1370ay
    /* renamed from: a */
    public void mo5106a() {
        C1786r.m6061b("onComplete logout", getClass().getSimpleName());
        CookieSyncManager.createInstance(this.f5372a.f4950f);
        CookieManager.getInstance().removeAllCookie();
        this.f5372a.m4815i();
        this.f5372a.finish();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1370ay
    /* renamed from: b */
    public void mo5107b() {
        C1786r.m6061b("onCancelled logout", getClass().getSimpleName());
        this.f5372a.m4815i();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1370ay
    /* renamed from: c */
    public void mo5108c() {
        C1786r.m6054a("onError logout", InviteFacebookActivity.f4944k);
        this.f5372a.m4810f();
        this.f5372a.m4797a(false);
    }
}
