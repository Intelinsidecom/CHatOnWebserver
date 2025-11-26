package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.settings.tellfriends.common.AsyncTaskC2801q;
import com.sec.chaton.settings.tellfriends.common.C2785a;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2786b;
import weibo4android.http.AccessToken;

/* compiled from: WeiboManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ca */
/* loaded from: classes.dex */
public class C2778ca implements InterfaceC2786b {

    /* renamed from: a */
    final /* synthetic */ C2770bt f10209a;

    /* renamed from: b */
    private int f10210b;

    public C2778ca(C2770bt c2770bt, int i) {
        this.f10209a = c2770bt;
        this.f10210b = i;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2786b
    /* renamed from: a */
    public void mo541a(Object obj) {
        this.f10209a.m10014b("Login Request:" + this.f10210b + " Done.");
        if (obj instanceof AccessToken) {
            AccessToken accessToken = (AccessToken) obj;
            C2780cc.m9917a(accessToken, this.f10209a.f10300b);
            new AsyncTaskC2801q(this.f10209a, this.f10210b).execute(new C2774bx(this.f10209a, accessToken, null));
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2786b
    /* renamed from: a */
    public void mo540a(C2785a c2785a) {
        this.f10209a.m10015c("Login Request:" + this.f10210b + " Webview Error. " + c2785a.getMessage());
        if (c2785a.m9994a() != -1002) {
            this.f10209a.f10301c.mo9799a(this.f10210b, c2785a.m9994a(), c2785a.getMessage());
        } else {
            this.f10209a.f10301c.mo9799a(this.f10210b, -1002, c2785a.getMessage());
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2786b
    /* renamed from: a */
    public void mo539a() {
        this.f10209a.m10014b("Login Request:" + this.f10210b + " Canceled.");
        this.f10209a.f10301c.mo9799a(this.f10210b, 0, null);
    }
}
