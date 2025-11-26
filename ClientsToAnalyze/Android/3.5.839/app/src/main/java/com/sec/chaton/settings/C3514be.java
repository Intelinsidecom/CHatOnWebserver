package com.sec.chaton.settings;

import android.webkit.CookieManager;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.sns.p114b.InterfaceC4377ac;
import com.sec.chaton.util.C4904y;

/* compiled from: ActivityManageAccounts.java */
/* renamed from: com.sec.chaton.settings.be */
/* loaded from: classes.dex */
class C3514be implements InterfaceC4377ac {

    /* renamed from: a */
    final /* synthetic */ ActivityManageAccounts f13002a;

    C3514be(ActivityManageAccounts activityManageAccounts) {
        this.f13002a = activityManageAccounts;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4377ac
    /* renamed from: a */
    public void mo13845a() {
        C4904y.m18639b("onComplete() \t- Logout", this.f13002a.f12519b);
        CookieManager.getInstance().removeAllCookie();
        this.f13002a.m13404e();
        C4368e.m16564a(this.f13002a.getApplicationContext()).m16565a(C4368e.f15815a, false);
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4377ac
    /* renamed from: b */
    public void mo13846b() {
        C4904y.m18639b("onCancelled() \t- Logout", this.f13002a.f12519b);
        this.f13002a.m13404e();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4377ac
    /* renamed from: c */
    public void mo13847c() {
        C4904y.m18634a("onError() \t- Logout", this.f13002a.f12519b);
        this.f13002a.m13404e();
        this.f13002a.m13410h();
    }
}
